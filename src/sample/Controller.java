package sample;


import java.util.*;

import com.google.gson.JsonArray;
import com.webcerebrium.binance.api.BinanceApi;
import com.webcerebrium.binance.api.BinanceApiException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.math.BigDecimal;

public class Controller {
    public String pricePair = "";
    public ChoiceBox altCoins;
    public ChoiceBox bigCoins;
    public JsonArray allTrades;
    public List altcoinsList = new ArrayList();
    public List bigCoinsList = new ArrayList();
    public ImageView logoImage;

    public Button updateButton;
    public Label priceText;

    public void getPrice(ActionEvent actionEvent) {
        Runnable task = () -> runTask();
        Thread backgroundThread = new Thread(task);
        backgroundThread.setDaemon(true);
        backgroundThread.start();
    }

    public void initialize(){
        altcoinsList.addAll(Arrays.asList("TRX","XRP","CMT","WTC","NANO","DGD","GAS","BCC","BTM","HCC","HSR","OAX","DNT","MCO","ICN","ZRX","OMG","PIVX","LRC","LLT","YOYO","NEO","STRAT","SNGLS","BQX","KNC","SNM","FUN","LINK","XVG","CTR","SALT","MDA","IOTA","SUB","ETC","MTL","MTH","ENG"));
        bigCoinsList.addAll(Arrays.asList("BTC","ETH","LTC","BNB"));
        Collections.sort(altcoinsList);
        altCoins.getItems().addAll(altcoinsList);
        bigCoins.getItems().addAll(bigCoinsList);
    }

    public void runTask() {
        String altCoin = altCoins.getValue().toString();
        String bigCoin = bigCoins.getValue().toString();
        final String altCoinFinal = altCoin;
        final String bigCoinFinal = bigCoin;

        while(altCoin == altCoinFinal && bigCoin == bigCoinFinal){
            BigDecimal btcPrice = null;
            String btcPriceString = "";

            try {
                altCoin = altCoins.getValue().toString();
                bigCoin = bigCoins.getValue().toString();
                pricePair = altCoin + bigCoin;
            } catch (java.lang.NullPointerException e) {
                System.out.println("HI");
                priceText.setText("ERROR");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Not a Valid Pair");
                alert.setHeaderText(null);
                alert.setContentText("You have chosen a trading pair that is not valid.");
                alert.showAndWait();
            }

            try {
                btcPrice = new BinanceApi().pricesMap().get(pricePair);
            } catch (BinanceApiException e) {
                e.printStackTrace();
            }

            try {
                btcPriceString = btcPrice.toString();
            } catch (java.lang.NullPointerException e){
                priceText.setText("ERROR");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Not a Valid Pair");
                alert.setHeaderText(null);
                alert.setContentText("You have chosen a trading pair that is not valid.");
                alert.showAndWait();
            }
            final String altCoinText = altCoin;
            final String bigCoinText = bigCoin;
            final String btcPriceStringText = btcPriceString;
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    priceText.setText(altCoinText + " / " + bigCoinText + ":    " + btcPriceStringText);
                }
            });
            try {
                Thread.sleep(1000);
                System.out.println("THE THREAD IS SLEEP");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
