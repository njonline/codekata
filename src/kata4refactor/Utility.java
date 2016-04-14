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

    public Utility(File file) throws FileNotFoundException {
        this.file = file;
        fileReader = new FileReader(file);
        bufferedReader = new BufferedReader(fileReader);
    }

    protected String get_key_from_value(HashMap<String, Integer> hashMap, int difference) {
        String calc_diff = hashMap.entrySet().stream()
                .filter(entry -> entry.getValue() == difference)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList())
                .get(0);
        return calc_diff;
    }

    protected void calculation(HashMap<String, Integer> hashMap, ArrayList<String> key, ArrayList<String> value1, ArrayList<String> value2) {
        int sum = 0;

        for(int i = 0; i < value1.size(); i++) {
            if(value1.get(i).equals("") || value2.get(i).equals("")) {
                continue;
            } else {
                sum = Integer.parseInt(value1.get(i)) - Integer.parseInt(value2.get(i));
                hashMap.put(key.get(i), sum);
            }
        }
    }

    protected void read_file(int skip_value, int end_value, String line_separator, ArrayList<String> key, ArrayList<String> value1, ArrayList<String> value2, int column_key, int column_value1, int column_value2) throws IOException {
        int counter = 0;
        String line;

        while((line = bufferedReader.readLine()) != null) {
            if(counter < skip_value || counter >= end_value) {
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

    protected void format_and_read_file(int skip_value, String file_path, int line_skip_value, String line_separator, ArrayList<String> key, ArrayList<String> value1, ArrayList<String> value2, int column_key, int column_value1, int column_value2) throws IOException {
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
}
