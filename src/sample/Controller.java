package sample;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    Main run = new Main();
    List keysList = new ArrayList(run.getKeys());
    final String BINANCE_API_KEY = keysList.get(0).toString();
    final String BINANCE_SECRET_KEY = keysList.get(1).toString();

}
