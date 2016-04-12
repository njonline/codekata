import kata2.KarateChop;
import kata4.WeatherData;

import java.io.FileNotFoundException;
import java.io.IOException;

public class main {

    public static void main(String[] args) throws FileNotFoundException {

        WeatherData data = new WeatherData();

        try {
            data.get_key_from_value_stream();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
