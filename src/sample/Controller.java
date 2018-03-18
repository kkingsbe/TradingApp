package sample;

import com.webcerebrium.binance.api.BinanceApi;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.math.BigDecimal;

public class Controller {
    Main run = new Main();
    final String BINANCE_API_KEY = run.getKeys().get(0).toString();
    final String BINANCE_SECRET_KEY = run.getKeys().get(1).toString();

    public Button updateButton;
    public Label priceText;

    public void getPrice(ActionEvent actionEvent) {
        BigDecimal btcPrice = new BinanceApi().pricesMap().get("ETHBTC");
        String btcPriceString = btcPrice.toString();
        priceText.setText(btcPriceString);
    }
}
