package kata4;

import kata4refactor.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

public class DataMungerTest {

    @Test
    public void footballTest() throws IOException {
        FootballData data = new FootballData();
        assertEquals("Leicester", data.get_key_from_value());
    }

    @Test
    public void weatherTest() throws IOException {
        WeatherData data = new WeatherData();
        assertEquals(14, data.get_key_from_value_stream());
    }
}
