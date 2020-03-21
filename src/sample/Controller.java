package sample;

import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class Controller {

    @FXML
    public AnchorPane ap;

    @FXML
    private javafx.scene.control.Button openFile;

    @FXML
    private javafx.scene.control.Button saveFile;

    @FXML
    private HTMLEditor htmlEditor;

    @FXML
    private javafx.scene.control.TextField fileName;

    @FXML
    private javafx.scene.control.TextField fileVersion;

    private FileThread task;

    @FXML
    private void openButtonAction(javafx.event.ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open TXT File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt")
        );
        String fileFolderPath = Paths.get("./src/sample/TXTFiles").toAbsolutePath().normalize().toString();
        fileChooser.setInitialDirectory(new File(fileFolderPath));
        Window stage = ap.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            task = new FileThread(selectedFile);
            task.setOnSucceeded(this::threadDone);
            task.setOnFailed(this::threadFailed);
            Thread th = new Thread(task);
            th.setDaemon(true);
            htmlEditor.setDisable(true);
            saveFile.setDisable(true);
            openFile.setDisable(true);
            fileName.setDisable(true);
            fileVersion.setDisable(true);
            th.start();

            fileName.setText(getFileName(selectedFile));
            fileVersion.setText(getFileVersion(selectedFile));
        }
    }

    private void threadDone(WorkerStateEvent e) {
        String result = task.getValue();
        htmlEditor.setHtmlText(result);
        htmlEditor.setDisable(false);
        saveFile.setDisable(false);
        openFile.setDisable(false);
        fileName.setDisable(false);
        fileVersion.setDisable(false);
    }

    private void threadFailed(WorkerStateEvent event) {
        var e = event.getSource().getException();
        // Alert if something went wrong
        alertUser("Could not load file: "+e.getMessage(), "Failed to Load File");
        htmlEditor.setDisable(false);
        saveFile.setDisable(false);
        openFile.setDisable(false);
        fileName.setDisable(false);
        fileVersion.setDisable(false);
    }

    public void saveButtonAction(ActionEvent actionEvent) throws IOException {
        String newFileName = fileName.getText()+"-"+fileVersion.getText()+".txt";
        File newFile = new File("./src/sample/TXTFiles/"+newFileName);

        // Check if file name and version comply with regex
        if(!fileName.getText().matches("[a-zA-ZæøåÆØÅ0-9 ]*")) {
            // Alert user that current file name is invalid
            alertUser("The file name can only contain letters and numbers. Special characters such as - and / are not allowed.", "Invalid File Name");
            return;
        }
        if(!fileVersion.getText().matches("[0-9]*")) {
            // Alert user that current version number is invalid
            alertUser("The version can only contain whole numbers. Decimals, letters and special characters are not allowed.", "Invalid File Version");
            return;
        }

        // If file name is empty or blank, request that user fill in a document name.
        if(fileName.getText().equals("") || fileName.getText().isBlank()) {
            // Alert user that file save was denied
            alertUser("Fill in a valid document name!", "Saved Denied");
            return;
        }

        // If file version is empty or blank, assume it is version 1
        if(fileVersion.getText().equals("") || fileVersion.getText().isBlank()) {
            fileVersion.setText("1");
        }

        // Write editor content to file
        BufferedWriter writer = new BufferedWriter(new FileWriter("./src/sample/TXTFiles/"+newFileName));
        writer.write(htmlEditor.getHtmlText());
        writer.close();

        // Alert user that file save was successful
        alertUser("File was saved successfully as "+newFileName, "Saved Successfully");
    }

    public String getFileName(File fullFileName) {
        String[] nameParts = fullFileName.getName().split("[.\\-]");
        return nameParts[0];
    }

    public String getFileVersion(File fullFileName) {
        String[] nameParts = fullFileName.getName().split("[.\\-]");
        return nameParts[1];
    }

    public static void alertUser(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

}
