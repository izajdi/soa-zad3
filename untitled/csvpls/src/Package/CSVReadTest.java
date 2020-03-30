package Package;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class CSVReadTest {

    @org.junit.jupiter.api.Test
    void avgOpen() {
        List<List<Double>> llist1 = new ArrayList<~>();
        List<List<Double>> llist2 = new ArrayList<~>();
        List<List<Double>> llist3 = new ArrayList<~>();
        List<Double> list1 = new ArrayList<Double>();
        List<Double> list2 = new ArrayList<Double>();
        List<Double> list3 = new ArrayList<Double>();
        List<Double> list4 = new ArrayList<Double>();
        List<Double> list5 = new ArrayList<Double>();
        List<Double> list6 = new ArrayList<Double>();
        for(double i=1; i<2; i++){
            list1.add(i);
            list2.add(2*i);
            list3.add(3*i);
            list4.add(4*i);
            list5.add(5*i);
            list6.add(6*i);
        }
        llist1.add(list1);
        llist1.add(list2);
        llist2.add(list3);
        llist2.add(list4);
        llist3.add(list5);
        llist3.add(list6);
        double expcted_1 = 1.5;
        double expected_2 =
        assertEquals()
    }
}