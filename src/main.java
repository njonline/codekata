import kata2.KarateChop;
import kata4.FootballData;
import kata4.WeatherData;

import java.io.FileNotFoundException;
import java.io.IOException;

public class main {

    public static void main(String[] args) throws FileNotFoundException {

        WeatherData data = new WeatherData();
        FootballData footballData = new FootballData();

        try {
            footballData.get_key_from_value();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
