package kata4refactor;

import java.io.File;
import java.io.IOException;

public class FootballData {

    private File file;
    private Utility util;

    public FootballData() {
        file = new File("football.dat");
    }

    public void output_diff() {

    }

    public void format_file() throws IOException {
        util.format_and_read_file(1, "football.dat", 18, "-", 1, 6, 8);
    }
}
