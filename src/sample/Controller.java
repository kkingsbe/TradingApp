package sample;


import java.util.ArrayList;
import java.util.List;
import com.webcerebrium.binance.api.BinanceApi;
import com.webcerebrium.binance.api.BinanceApiException;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.math.BigDecimal;


public class Controller {
    public String pricePair = "ETHBTC";
    Main run = new Main();
    List keysList = new ArrayList(run.getKeys());
    final String BINANCE_API_KEY = keysList.get(0).toString();
    final String BINANCE_SECRET_KEY = keysList.get(1).toString();

    public Button updateButton;
    public Label priceText;

    public void getPrice(ActionEvent actionEvent) {
        BigDecimal btcPrice = null;
        try {
            btcPrice = new BinanceApi().pricesMap().get(pricePair);
        } catch (BinanceApiException e) {
            e.printStackTrace();
        }
        String btcPriceString = btcPrice.toString();
        priceText.setText("BTC to ETH: " + btcPriceString);
    }
}
