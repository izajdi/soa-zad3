package com.company;

import java.util.*;
import java.lang.String;

public class getAtoms {

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

    public static Map<String, Integer> multiplyValues(Map<String, Integer> hmap, int multiplier){
        Set<String> sset = hmap.keySet();
        for(String x: sset){
            hmap.put(x, hmap.get(x) * multiplier);
        }
        return hmap;
    }

    public static Map<String, Integer> getAtomss(String formula, int start, int end) {
        List<String> keys = new ArrayList<>();
        Map<String, Integer> hmap = new HashMap<>();
        Map<String, Integer> hmap1 = new HashMap<>();
        int counter = -1;
        boolean ifSkip = false;
        boolean skipper = false;
        int value_of_mulitiplier =1;
        for (int i = start; i < end; i++) {
            if (ifSkip) {
                ifSkip = false;
                continue;
            }
            if (skipper) {
                int counterOfLeftBracket = -1;
                for(int j=0; j<occurancesOfCharacter(formula, '(', start, end); j++){
                    counterOfLeftBracket = formula.indexOf(')', counterOfLeftBracket);
                }
                if(i != formula.length() && i+1 == counterOfLeftBracket ){
                    skipper = false;
                }
                continue;

            }
                else {
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
                if (Character.isDigit(formula.charAt(i)) && formula.charAt(i - 1) != ')') {
                    int numericChar = Character.getNumericValue(formula.charAt(i));
                    hmap.put(keys.get(counter), numericChar);
                }
                char s1 = '(';
                char s2 = ')';
                if(s1 == (formula.charAt(i))){
                    skipper = true;
                    int tmp_end = -1;
                    int multiplier = 1;
                    for(int j=0; j<occurancesOfCharacter(formula, '(', start, end); j++){
                        tmp_end = formula.indexOf(')', tmp_end + 1);
                    }
                    Map<String, Integer> hmap2 = getAtomss(formula, i + 1, tmp_end);
                    hmap1.putAll(hmap2);
                    hmap = addMaps(hmap, hmap1);
                }

            }
        }
        if(end != formula.length()){
            value_of_mulitiplier = Character.getNumericValue(formula.charAt(end + 1));
        }
        return multiplyValues(hmap, value_of_mulitiplier);
    }

    public static int occurancesOfCharacter(String formula, char a, int start, int end){
        int counter =0;
        for(int i=start; i<end; i++){
            if(formula.charAt(i) == a)
                counter++;
        }
        return counter;
    }

    /*public static Map<String, Integer> getAtomsWithoutBrackets(int start, int end, String formula, int multiplier){
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

    public static Map<String, Integer> getAtoms(String formula){
        return getAtomss(formula, 0, formula.length());
    }

    public static void main(String[] args) {

        String atom = "C6H12O6";
        String atom1 = "Mg(OH)2";
        System.out.println(getAtoms(atom));
    }
}
