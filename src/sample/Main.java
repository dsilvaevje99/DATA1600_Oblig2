package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main {

    public static void main(String[] args) {
        Oppg1_Rekursjon oppg1 = new Oppg1_Rekursjon();
        System.out.println(oppg1.sum(5,0));
        System.out.println(oppg1.pow(5,5));
        int[] array = {1, 2, 3, 4, 5};
        oppg1.backwardsArray(array, array.length-1);
    }

}
