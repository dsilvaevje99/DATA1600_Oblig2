package sample;

import javafx.concurrent.Task;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileThread extends Task<String> {
    private final File file;

    public FileThread(File file) {
        this.file = file;
    }

    private String fileContent = "";

    @Override
    protected String call() {
        try {
            List lines = Files.readAllLines(Paths.get(String.valueOf(file)), StandardCharsets.UTF_8);
            StringBuilder sb = new StringBuilder();
            for (int i=0 ; i<lines.size() ; i++) {
                sb.append(lines.get(i)+"<br/>");
            }

            fileContent = sb.toString();
        } catch (IOException e) {
        }

        return fileContent;
    }

}
