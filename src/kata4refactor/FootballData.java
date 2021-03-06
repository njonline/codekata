package kata4refactor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class FootballData {

    private File file;
    private Utility util;

    private ArrayList<String> value1, value2, key;
    private HashMap<String, Integer> hashMap;

    private int difference;

    private final int line_skip = 1;
    private final String file_name = "football.dat";
    private final int line_to_skip = 18;
    private final String separator = "-";
    private final int key_column = 1;
    private final int value1_column = 6;
    private final int value2_column = 9;

    public FootballData() throws IOException {
        file = new File("football.dat");
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

    private void format_file() throws IOException {
        util.format_and_read_file(line_skip, file_name, line_to_skip, separator, key, value1, value2, key_column, value1_column, value2_column);
    }
}
