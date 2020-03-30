package lab7and8;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class Main {
    public static void main(String[] arg) {
        String filename = "admin-units.csv";
        String delimiter = ",";
        AdminUnitList aulist = new AdminUnitList();
        try {
            aulist.read(filename, delimiter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintStream ps = new PrintStream(System.out);
        aulist.list(ps, 0, 5);

    }
}
