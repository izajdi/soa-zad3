package PAcakge;

import PAcakge.CSVRead;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] arg) {
        String s1 = "NIFTY_50_Data.csv";
        String s2 = ",";
        CSVRead reader = null;
        try {
            reader = new CSVRead(s1, s2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            if (reader.parseHeader()) {
                System.out.println(reader.getColumnNames());
            }
            reader.parseFile();
            System.out.println(reader.getBigData());
            String month1 = "Oct";
            String month2 = "Sep";
            reader.parseMonth(month1, reader.getOctoberData());
            reader.makeMaxDiffrencesOctober();
            reader.parseMonth(month2, reader.getSeptemberData());
            reader.makeMaxDiffrencesSeptember();
            System.out.println(reader.getMaxDiffrencesOctober());
            System.out.println(reader.getMaxDiffrencesSeptember());
            System.out.println(reader.avgOpen(reader.getOctoberData()));
            System.out.println(reader.avgOpen(reader.getSeptemberData()));
            System.out.println(reader.getResultOctober());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
