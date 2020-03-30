package PAcakge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVRead {
    String filename;
    String[] current;
    String delimiter;
    BufferedReader reader;
    List<String> columnNames = new ArrayList<>();
    List<List<String>> bigData = new ArrayList<List<String>>();
    List<List<Double>> octoberData = new ArrayList<List<Double>>();
    List<List<Double>> septemberData = new ArrayList<List<Double>>();
    List<Double> MaxDiffrencesOctober = new ArrayList<>();
    List<Double> MaxDiffrencesSeptember = new ArrayList<>();


    public CSVRead(String filename_, String delimiter_) throws FileNotFoundException {
        this.filename = filename_;
        this.delimiter = delimiter_;
        reader = new BufferedReader(new FileReader(filename));
    }

    public String clearString(String s1){
        return s1.replaceAll("[\"\']", "");
    }

    String [] clearCurrent(String []string_array){
        for(int i=0; i<string_array.length; i++){
            string_array[i] = clearString(string_array[i]);
        }
        return string_array;
    }

    List<Double> getDoubleList(List<String> str){
        List<Double> alist = new ArrayList<>();
        double current =0;
        for(int i=1; i<str.size(); i++){
            current = Double.parseDouble(str.get(i));
            alist.add(current);
        }
        return alist;
    }

    void makeMaxDiffrencesOctober(){
        for(int i=0; i<octoberData.size(); i++){
                MaxDiffrencesOctober.add((octoberData.get(i)).get(1) / (octoberData.get(i).get(2)));
        }
    }

    void makeMaxDiffrencesSeptember(){
        for(int i=0; i<septemberData.size(); i++){
            MaxDiffrencesSeptember.add((septemberData.get(i)).get(1) / (septemberData.get(i).get(2)));
        }
    }

    public static double avgOpen(List<List<Double>> table){
        double result =0;
        for(int i=0; i<table.size(); i++){
            result += table.get(i).get(0);
        }
        return result/table.size();
    }

    String getResultOctober(){
        StringBuilder s1 = new StringBuilder();
        s1.append("October: ");
        s1.append(octoberData.size());
        s1.append(" avgopen(October) = ");
        s1.append(avgOpen(octoberData));
        return s1.toString();
    }
    boolean strContains(String str1, String str2){
        if(str1.contains(str2)){
            return true;
        }
        else{
            return false;
        }
    }

    void parseMonth(String str, List<List<Double>> result){
        boolean checker;
        for(int i=0; i<bigData.size(); i++)
            if (strContains(((bigData.get(i)).get(0)), str)) {
                result.add(getDoubleList(bigData.get(i)));
            }
    }



    boolean parseHeader() throws IOException {
        String s1 = "";
        if(reader.ready()){
            s1 = reader.readLine();
            current = s1.split(delimiter);
            columnNames = Arrays.asList(clearCurrent(current));
            return true;
        }
        return false;
    }

    public List<String> getColumnNames() {
        return columnNames;
    }

    public List<List<String>> getBigData(){
        return bigData;
    }

    public List<Double> getMaxDiffrencesOctober(){
        return MaxDiffrencesOctober;
    }

    public List<Double> getMaxDiffrencesSeptember(){
        return MaxDiffrencesSeptember;
    }

    public List<List<Double>> getOctoberData(){
        return octoberData;
    }
    public List<List<Double>> getSeptemberData(){
        return septemberData;
    }

    void parseFile() throws IOException {
        String line = null;
        while((line = reader.readLine()) != null){
            current = line.split(delimiter);
            bigData.add(Arrays.asList(clearCurrent(current)));
        }
    }

}
