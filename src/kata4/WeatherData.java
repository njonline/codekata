package kata4;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Read text file weather.dat
 * Output number of day (column 1) that has smallest temperature spread
 * Max temp = second column
 * Min temp = third column
 */
public class WeatherData {

    private File data;
    private FileReader fileReader;
    private BufferedReader bufferedReader;

    private ArrayList<String> date;
    private ArrayList<String> max_temp;
    private ArrayList<String> min_temp;
    private HashMap<Integer, Integer> diff_temp;

    private int diff;

    public WeatherData() throws FileNotFoundException {
        data = new File("weather.dat");
        fileReader = new FileReader(data);
        bufferedReader = new BufferedReader(fileReader);

        date = new ArrayList<String>();
        max_temp = new ArrayList<String>();
        min_temp = new ArrayList<String>();
        diff_temp = new HashMap<Integer, Integer>();
    }

    public int get_key_from_value_stream() throws IOException {
        this.calculation();

        int lowest_value = diff_temp.entrySet().stream()
                .filter(entry -> entry.getValue() == diff)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList())
                .get(0);
        System.out.println(lowest_value);
        return lowest_value;
    }

    private int calculation() throws IOException {
        this.output();
        int sum;

        for(int i = 0; i < 30; i++) {
            sum = Integer.parseInt(max_temp.get(i)) - Integer.parseInt(min_temp.get(i));
            diff_temp.put(Integer.parseInt(date.get(i)), sum);
        }
        System.out.println(diff_temp);
        return diff = Collections.min(diff_temp.values());
    }

    private void output() throws IOException {
        int counter = 0;
        String line;

        while((line = bufferedReader.readLine()) != null) {
            if(counter < 2 || counter >= 32) {
                counter++;
                continue;
            } else {
                line = line.trim().replaceAll(" +", ",");
                line = line.trim().replace("*", "");
                String[] data = line.split(",");
                date.add(data[0]);
                max_temp.add(data[1]);
                min_temp.add(data[2]);
                counter++;
            }
        }
        bufferedReader.close();
    }

}
