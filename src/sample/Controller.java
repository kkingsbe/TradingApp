package sample;


import java.util.*;

import com.google.gson.JsonArray;
import com.webcerebrium.binance.api.BinanceApi;
import com.webcerebrium.binance.api.BinanceApiException;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.math.BigDecimal;

public class Controller {
    public String pricePair = "";
    public ChoiceBox altCoins;
    public ChoiceBox bigCoins;
    public ImageView logoImage;
    Main run = new Main();
    //List keysList = new ArrayList(run.getKeys());
    //final String BINANCE_API_KEY = keysList.get(0).toString();
    //final String BINANCE_SECRET_KEY = keysList.get(1).toString();
    public JsonArray allTrades;
    public List altcoinsList = new ArrayList();
    public List bigCoinsList = new ArrayList();

    public Button updateButton;
    public Label priceText;

    public void getPrice(ActionEvent actionEvent) {
        BigDecimal btcPrice = null;
        String altCoin = "";
        String bigCoin = "";
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
            System.out.println("HI");
            priceText.setText("ERROR");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Not a Valid Pair");
            alert.setHeaderText(null);
            alert.setContentText("You have chosen a trading pair that is not valid.");
            alert.showAndWait();
        }

        priceText.setText(altCoin + " / " + bigCoin + ":    " + btcPriceString);
    }

    public void initialize(){
        altcoinsList.addAll(Arrays.asList("TRX","XRP","CMT","WTC","NANO","DGD","GAS","BCC","BTM","HCC","HSR","OAX","DNT","MCO","ICN","ZRX","OMG","PIVX","LRC","LLT","YOYO","NEO","STRAT","SNGLS","BQX","KNC","SNM","FUN","LINK","XVG","CTR","SALT","MDA","IOTA","SUB","ETC","MTL","MTH","ENG"));
        bigCoinsList.addAll(Arrays.asList("BTC","ETH","LTC","BNB"));
        Collections.sort(altcoinsList);
        altCoins.getItems().addAll(altcoinsList);
        bigCoins.getItems().addAll(bigCoinsList);
    }

}
