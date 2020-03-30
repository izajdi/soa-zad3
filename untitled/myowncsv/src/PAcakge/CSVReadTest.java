package PAcakge;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static PAcakge.CSVRead.avgOpen;
import static org.junit.jupiter.api.Assertions.*;

class CSVReadTest {


    @org.junit.jupiter.api.Test
    void clearString() {
        double a=2;
        double b=2;
        assertEquals(a,b);
    }

    @org.junit.jupiter.api.Test
    void clearCurrent() {
    }

    @org.junit.jupiter.api.Test
    void parseHeader() {
    }

    @org.junit.jupiter.api.Test
    void getColumnNames() {
    }

    @org.junit.jupiter.api.Test
    void getBigData() {
    }

    @org.junit.jupiter.api.Test
    void parseFile() {
    }

    @Test
    void testClearString() {
    }

    @Test
    void testClearCurrent() {
    }

    @Test
    void getDoubleList() {
    }

    @Test
    void makeMaxDiffrencesOctober() {
    }

    @Test
    void makeMaxDiffrencesSeptember() {
    }

    @Test
    void avgOpenTest() {
        List<List<Double>> alist = new ArrayList<List<Double>>();
        List<Double> list_1 = new ArrayList<Double>();
        List<Double> list_2 = new ArrayList<Double>();
        for(double i=1; i<3; i++){
            list_1.add(i);
            list_2.add(i*2);
        }

        alist.add(list_1);
        alist.add(list_2);
        double result = 1.5;
        assertEquals(result, avgOpen(alist));

    }
    @Test
    void getResultOctober() {
    }

    @Test
    void strContains() {
    }

    @Test
    void parseMonth() {
    }

    @Test
    void testParseHeader() {
    }

    @Test
    void testGetColumnNames() {
    }

    @Test
    void testGetBigData() {
    }

    @Test
    void getMaxDiffrencesOctober() {
    }

    @Test
    void getMaxDiffrencesSeptember() {
    }

    @Test
    void getOctoberData() {
    }

    @Test
    void getSeptemberData() {
    }

    @Test
    void testParseFile() {
    }
}