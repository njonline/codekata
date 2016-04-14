package kata4refactor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class WeatherData {

    private File file;
    private Utility util;

    private ArrayList<String> key, value1, value2;
    private HashMap<String, Integer> hashMap;

    private int difference;

    private final int line_skip = 2;
    private final int max_line_to_read = 32;
    private final String separator = "*";
    private final int key_column = 0;
    private final int value1_column = 1;
    private final int value2_column = 2;

    public WeatherData() throws IOException {
        file = new File("weather.dat");
        value1 = new ArrayList<>();
        value2 = new ArrayList<>();
        key = new ArrayList<>();
        hashMap = new HashMap<>();
        util = new Utility(file);
    }

    public String get_key() throws IOException {
        this.format_file();
        this.output_diff();
        return util.get_key_from_value(hashMap, difference);
    }

    private void output_diff() {
        util.calculation(hashMap, key, value1, value2);
        difference = Collections.min(hashMap.values());
    }

    public void format_file() throws IOException {
        util.read_file(line_skip, max_line_to_read, separator, key, value1, value2, key_column, value1_column, value2_column);
    }
}
