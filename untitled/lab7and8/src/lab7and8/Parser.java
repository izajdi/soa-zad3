package lab7and8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Parser {
    List<List<String>> dates = new ArrayList<List<String>>();
    String filename;
    String delimiter;
    String[] current;
    BufferedReader reader;

    public Parser(String filename_, String delimiter_) throws FileNotFoundException {
        this.filename = filename_;
        this.delimiter = delimiter_;
        reader = new BufferedReader(new FileReader(filename));
    }

    void parseFile() throws IOException {
        String line = null;
        int counter = 0;
        while (((line = reader.readLine()) != null) && counter < 100) {
            counter++;
            current = line.split(delimiter);
            dates.add(Arrays.asList(current));
        }

    }

    public List<List<String>> getDates(){
        return dates;
    }

}
