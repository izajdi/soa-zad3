
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

import static java.lang.Character.toUpperCase;

public class HelloWord {
String s;
    HelloWord(String s_){
        s = s_;
    }

    void printhtml(PrintStream out){
        out.printf("elo bart %x", s);
    }

    static String changerString(String s1){
        Map<Character, Boolean> map1 = new HashMap<Character, Boolean>();
        for(int i=0; i<s1.length(); i++){
            if(map1.containsKey(s1.charAt(i))){
                map1.put(s1.charAt(i), false);
            }
            else{
                map1.put(s1.charAt(i), true);
            }
        }
        StringBuilder s2 = new StringBuilder();
        for(int j=0; j<s1.length(); j++){
            if(map1.get(s1.charAt(j))){
                s2.append("(");
            }
            else{
                s2.append(")");
            }
        }
        return s2.toString();
    }

    /*'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm' */
    static String printError(String s1){
        int denominator = s1.length();
        int counter =0;
        List<Character> alist = List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm');
        for(int i=0; i<s1.length(); i++){
            if(!alist.contains(s1.charAt(i))){
                counter++;
            }
        }
        StringBuilder s2 = new StringBuilder();
        s2.append("\"");
        s2.append(counter);
        s2.append("/");
        s2.append(denominator);
        s2.append("\"");
        return s2.toString();
    }

    public static int solution(int number){
        List<Integer> alist = new ArrayList<>();
        for(int i=0; 3*i<number; i++){
            alist.add(3*i);
        }
        for(int j=0; 5*j<number; j++){
            if(!alist.contains(5*j)){
                alist.add(5*j);
            }
        }
        int counter =0;
        for(int k: alist){
            counter +=k;
        }
        return counter;
    }
    public static String createPhoneNumber(int []numbers){
        StringBuilder s1 = new StringBuilder();
        s1.append("(");
        for(int i=0; i<3; i++){
            s1.append(numbers[i]);
        }
        s1.append(") ");
        for(int i=3; i<6; i++){
            s1.append(numbers[i]);
        }
        s1.append("-");
        for(int i=6; i<numbers.length; i++){
            s1.append(numbers[i]);
        }
        return s1.toString();
    }

    public static String disvowel(String str){
        return str.replaceAll("[aAeEiIoOuU]", "");

    }
    public static String kolosTry(String str){
        return str.replaceAll("[\"\']", "");
    }

    public static String[] clearString(String []string_array){
        for(int i=0; i<string_array.length; i++){
            string_array[i] = kolosTry(string_array[i]);
        }
        return string_array;
    }

    public static int[] deleteNth(int[] elements, int max0ccurrences){
        Map<Integer, Integer> hmap = new HashMap<>();
        List<Integer> alist = new ArrayList<>();
        for(int i=0; i<elements.length; i++){
            if(!hmap.containsKey(elements[i])){
                hmap.put(elements[i], 1);
            }
            else{
                hmap.put(elements[i], hmap.get(elements[i]) + 1);
            }
            if(hmap.get(elements[i]) < max0ccurrences + 1){
                alist.add(elements[i]);
            }
        }
        int []result = new int[alist.size()];
        return result;

    }

    public static String camelCase(String str){
        String []tab = str.split(" ");
        StringBuilder s1 = new StringBuilder();
        for(int i=0; i<tab.length; i++){
            for(int j=0; j<tab[i].length(); j++){
                if(j ==0) s1.append(toUpperCase(tab[i].charAt(j)));
                else{ s1.append(tab[i].charAt(j)); }
            }
        }
        return s1.toString();
    }

    public static String makeReadable(int seconds){
        return String.format("%02d:%02d:%02d", seconds/3600, (seconds/60) % 60, seconds % 60);
    }

    public static void list(){
        PrintStream ps = new PrintStream(System.out);
        ps.print("a");
        ps.print("b");
    }

    public static boolean check(String sentence){
        Map<Character, Boolean> map = new HashMap<Character, Boolean>();
        String lowerCaseSentace = sentence.toLowerCase();
        for(int i=0; i<26; i++){
            map.put((char)(97 + i), false);
        }
        for(int i=0; i<lowerCaseSentace.length(); i++){
            map.put(lowerCaseSentace.charAt(i), true);
        }
        if(map.containsValue(false)){
            return false;
        }
        else{
            return true;
        }
    }

    public static String doubleTree(int n){
        if(n%2 == 0 || n <= 0){
            return null;
        }
        StringBuilder sb= new StringBuilder();
        for(int i=0; i<(n+1)/2; i++){
            for(int j = ((n-1)/2 - i); j>0; j--){
                sb.append(" ");
            }
            for(int q=0; q<(i*2 + 1); q++){
                sb.append("*");
            }
            sb.append("\n");
        }
        for(int i=(n-1)/2; i>0; i--){
            for(int j =0; j<((n+1)/2 - i); j++){
                sb.append(" ");
            }
            for(int q= (i*2 - 1); q>0; q--){
                sb.append("*");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /*public static String Tickets(int[] peopleInLine){

    }

    public static Map<String, Integer> getAtoms(String formula) {
        List<String> keys = new ArrayList<>();
        Map<String, Integer> hmap = new HashMap<>();
        int counter = -1;
        boolean ifSkip = false;
        for (int i = 0; i < formula.length(); i++) {
            if (ifSkip) {
                ifSkip = false;
                continue;
            } else {
                StringBuilder sb = new StringBuilder();
                if (Character.isUpperCase(formula.charAt(i))) {
                    sb.append(formula.charAt(i));
                    if (formula.length() != (i + 1) && Character.isLowerCase(formula.charAt(i + 1))) {
                        sb.append(formula.charAt(i + 1));
                        ifSkip = true;
                    }
                    hmap.put(sb.toString(), 1);
                    counter++;
                    keys.add(sb.toString());

                }
                if (Character.isDigit(formula.charAt(i))) {
                    int numericChar = Character.getNumericValue(formula.charAt(i));
                    hmap.put(keys.get(counter), numericChar);
                }
            }
        }
        return hmap;
    }

    public static int occurancesOfCharacter(String formula, char a){
        int counter =0;
        for(int i=0; i<formula.length(); i++){
            if(formula.charAt(i) == a)
                counter++;
        }
        return counter;
    }

    public static Map<String, Integer> getAtomsWithoutBrackets(int start, int end, String formula){
        List<String> keys = new ArrayList<>();
        Map<String, Integer> hmap = new HashMap<>();
        int counter = -1;
        boolean ifSkip = false;
        for (int i = 0; i <formula.length(); i++) {
            if (ifSkip) {
                ifSkip = false;
                continue;
            } else {
                StringBuilder sb = new StringBuilder();
                if (Character.isUpperCase(formula.charAt(i))) {
                    sb.append(formula.charAt(i));
                    if (formula.length() != (i + 1) && Character.isLowerCase(formula.charAt(i + 1))) {
                        sb.append(formula.charAt(i + 1));
                        ifSkip = true;
                    }
                    hmap.put(sb.toString(), 1);
                    counter++;
                    keys.add(sb.toString());

                }
                if (Character.isDigit(formula.charAt(i))) {
                    int numericChar = Character.getNumericValue(formula.charAt(i));
                    hmap.put(keys.get(counter), numericChar);
                }

            }
        }
        return hmap;
    }*/

    public static Map<String, Integer> addMaps(Map<String, Integer> hmap1, Map<String, Integer> hmap2){
        Set<String> sset = hmap2.keySet();
        for(String x:sset){
            if(!hmap1.containsKey(x)){
                hmap1.put(x, hmap2.get(x));
            }
            else{
                hmap1.put(x, hmap1.get(x) + hmap2.get(x));
            }
        }
        return hmap1;
    }



    public static void main(String[] args) {

        /*String []table = new String[]{"\"coto\"", "\'cis\'"};
        clearString(table);
        for(int i=0; i<2; i++){
            System.out.println(table[i]);
        }
        int sec= 60;
        System.out.println(makeReadable(sec));
        List<Integer> alist = new ArrayList<Integer>(Arrays.asList(1 , 2, 3));
        System.out.println(alist);

        System.out.println(doubleTree(5));
        System.out.println(doubleTree(3));
        System.out.println(doubleTree(7));
        */
        Map<String, Integer> hmap = new HashMap<>();
        Map<String, Integer> hmap1 = new HashMap<>();
        Set<String> sset = new HashSet<>();
        hmap.put("O", 3);
        hmap.put("K", 4);
        hmap1.put("O", 1);
        hmap1.put("K", 2);
        System.out.println(addMaps(hmap1, hmap));
        String s1 = "B";
        String s2 = "C";
        System.out.println(s1.equals(s2));





    }


}

