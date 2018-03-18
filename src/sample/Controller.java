package sample;


import java.util.ArrayList;
import java.util.List;
import com.webcerebrium.binance.api.BinanceApi;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.math.BigDecimal;


public class Controller {
    Main run = new Main();
    List keysList = new ArrayList(run.getKeys());
    final String BINANCE_API_KEY = keysList.get(0).toString();
    final String BINANCE_SECRET_KEY = keysList.get(1).toString();

    public Button updateButton;
    public Label priceText;

    public void getPrice(ActionEvent actionEvent) {
        BigDecimal btcPrice = new BinanceApi().pricesMap().get("ETHBTC");
        String btcPriceString = btcPrice.toString();
        priceText.setText(btcPriceString);
    }
}
