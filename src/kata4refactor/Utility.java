package kata4refactor;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Refactor the two classes from the first two exercises.
 * Factor out as much common code as possible.
 * End up with two smaller programs with shared functionality.
 */
public class Utility {

    private File file;
    private FileReader fileReader;
    private BufferedReader bufferedReader;

    private ArrayList<String> value1, value2, key;
    private HashMap<String, Integer> hashMap;

    private int difference;

    public Utility(File file) throws FileNotFoundException {
        this.file = file;
        fileReader = new FileReader(file);
        bufferedReader = new BufferedReader(fileReader);
        value1 = new ArrayList<String>();
        value2 = new ArrayList<String>();
        key = new ArrayList<String>();
        hashMap = new HashMap<String, Integer>();
    }

    protected String get_key_from_value() {
        String calc_diff = this.getHashMap().entrySet().stream()
                .filter(entry -> entry.getValue() == this.getDifference())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList())
                .get(0);
        System.out.println(calc_diff);
        return calc_diff;
    }

    protected void calculation() {
        int sum = 0;

        for(int i = 0; i < value1.size(); i++) {
            sum = Integer.parseInt(this.getValue1().get(i)) - Integer.parseInt(this.getValue2().get(i));
            hashMap.put(key.get(i), sum);
        }
        difference = Collections.min(hashMap.values());
    }

    protected void format_and_read_file(int skip_value, String file_path, int line_skip_value, String line_separator, int column_key, int column_value1, int column_value2) throws IOException {
        int counter = 0;
        String line;
        String line_to_skip = Files.readAllLines(Paths.get(file_path)).get(line_skip_value);

        while((line = bufferedReader.readLine()) != null) {
            if(counter < skip_value || line.equals(line_to_skip)) {
                counter++;
                continue;
            } else {
                line = line.trim().replaceAll(" +", ",");
                line = line.trim().replace(line_separator, ",");
                String data[] = line.split(",");
                key.add(data[column_key]);
                value1.add(data[column_value1]);
                value2.add(data[column_value2]);
                counter++;
            }
        }
    }

    public ArrayList<String> getValue1() {
        return value1;
    }

    public ArrayList<String> getValue2() {
        return value2;
    }

    public HashMap<String, Integer> getHashMap() {
        return hashMap;
    }

    public int getDifference() {
        return difference;
    }
}
