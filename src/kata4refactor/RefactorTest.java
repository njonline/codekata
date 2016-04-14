package kata4refactor;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

public class RefactorTest {

    @Test
    public void testFootballData() throws IOException {
        FootballData data = new FootballData();
        assertEquals("Leicester", data.get_key());
    }

    @Test
    public void testWeatherData() throws IOException {
        WeatherData data = new WeatherData();
        assertEquals("14", data.get_key());
    }
}
