package kata4;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Read text file football.dat
 * Output team with lowest difference in goals for and against
 * Goals for is labelled A
 * Goals against is labelled F
 */
public class FootballData {

    private File data;
    private FileReader fileReader;
    private BufferedReader bufferedReader;

    private ArrayList<String> goals_for;
    private ArrayList<String> goals_against;
    private ArrayList<String> team;
    private HashMap<String, Integer> goal_diff;

    private int diff;

    public FootballData() throws FileNotFoundException {
        data = new File("football.dat");
        fileReader = new FileReader(data);
        bufferedReader = new BufferedReader(fileReader);

        goals_for = new ArrayList<String>();
        goals_against = new ArrayList<String>();
        team = new ArrayList<String>();
        goal_diff =  new HashMap<String, Integer>();
    }

    public String get_key_from_value() throws IOException {
        this.calculation();

        String lowest_diff = goal_diff.entrySet().stream()
                .filter(entry -> entry.getValue() == diff)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList())
                .get(0);
        return lowest_diff;
    }

    private int calculation() throws IOException {
        this.output();
        int sum = 0;

        for(int i = 0; i < goals_against.size(); i++) {
            sum = Integer.parseInt(goals_for.get(i)) - Integer.parseInt(goals_against.get(i));
            goal_diff.put(team.get(i), sum);
        }
        return diff = Collections.min(goal_diff.values());
    }

    private void output() throws IOException {
        int counter = 0;
        String line;
        String line_to_skip = Files.readAllLines(Paths.get("football.dat")).get(18);

        while((line = bufferedReader.readLine()) != null) {
            if(counter < 1 || line.equals(line_to_skip)) {
                counter++;
                continue;
            } else {
                line = line.trim().replaceAll(" +", ",");
                line = line.trim().replace("-", "");
                String data[] = line.split(",");
                team.add(data[1]);
                goals_for.add(data[6]);
                goals_against.add(data[8]);
                counter++;
            }
        } bufferedReader.close();
    }
}
