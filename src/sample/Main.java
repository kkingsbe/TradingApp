package sample;

import com.webcerebrium.binance.api.BinanceApi;
import com.webcerebrium.binance.api.BinanceApiException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 878, 543));
        primaryStage.show();

    }
/*
    public List getKeys(){
        Scanner key = new Scanner(System.in);
        System.out.print("API KEY:    ");
        String BINANCE_API_KEY = key.next();
        System.out.print("BINANCE_SECRET_KEY:    ");
        String BINANCE_SECRET_KEY = key.next();
        List keys = new ArrayList();
        keys.add(BINANCE_API_KEY);
        keys.add(BINANCE_SECRET_KEY);
        return keys;
    }
*/
    public static void main(String[] args) {
        launch(args);

    }

}
