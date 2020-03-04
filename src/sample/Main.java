package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("DATA1600");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

        //OPPGAVE 1 - Rekursjon
        Oppg1_Rekursjon oppg1 = new Oppg1_Rekursjon();
        System.out.println(oppg1.sum(5,0));
        System.out.println(oppg1.pow(5,5));
        int[] array = {2, 3, 1, 4, 5};
        oppg1.backwardsArray(array, array.length-1);
        System.out.println(oppg1.smallestNumberInArray(array, 0, Integer.MAX_VALUE));
        System.out.println(oppg1.searchRec(array, 0, array.length-1, 3));

        /*
        OPPGAVE 3 - Designmønstre
        3.1 Eksempel på problem som kan løses av State designmønster:
            Det skal implementeres et system for å varsle fører når bensintank er full, lav eller kritisk lav.

            Eksempel på problem som kan løses av Strategy designmønster:
            Det skal implementeres et betalingssystem der bruker kan betale med kredittkort, PayPal eller Vipps (Eks: RuterBillett-appen).

         3.3 1. draw() metoden burde være abstrakt fordi alle formene skal tegnes med metoden, men må tegnes på forskjellig måte.
             2.
             3. Composite designmønsteret kan brukes til å la en gruppe med former være representert som ett objekt ved å implementere
                et felles interface, og la hver form være en egen klasse som implementerer denne.
         */
    }

}
