package sample;

import com.google.gson.*;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.webcerebrium.binance.api.BinanceApi;
import com.webcerebrium.binance.api.BinanceApiException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 878, 543));
        primaryStage.show();
        try {
            btcticker();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    public static void btcticker() throws IOException {
        //URL connection
        Gson gson = new Gson();
        URL url = new URL("http://api.bitcoincharts.com/v1/markets.json");
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        Type listType = new TypeToken<ArrayList<test>>(){}.getType();
        Object readerArray = new GsonBuilder().create().fromJson(reader, listType);
    }
     class test {
         @SerializedName("currency")
         private String currency;
        //public String currency;
         public test(String currency){
             this.currency = currency;
         }
         public String getCurrency() {
             return currency;
         }
         public void setCurrency(String post_name) {
             this.currency = post_name;
    }

}}

