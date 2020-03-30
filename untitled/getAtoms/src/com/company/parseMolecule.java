package com.company;

import java.util.*;
import java.lang.String;

class Main {
    public static void main(String[] args) {
        System.out.println(ParseMolecule.getAtoms("O2(K4S4N2O2O12)"));
        //ParseMolecule.getAtoms("H2O");
        //ParseMolecule.getAtoms("MgO2H2");
        //ParseMolecule.testing("O2{K4[ON(SO3)2]2}");
//ParseMolecule.testing("O2{K4[ONS2O6]2}");
        //ParseMolecule.testing("O2(K4S4N2O2O12)");
        //O2{K4[ONS2O6]2}
    }
}



class ParseMolecule {

    public static Map<String, Integer> getAtoms(String formula) {
        //System.out.println("hello");

        HashMap hm = new HashMap<>();

        for (int i = 0; i < formula.length(); i++) {

            Character cChar = formula.charAt(i);
            String currentChar = String.valueOf(cChar);

            Character nChar = null;
            String nextChar = null;

            if ((i + 1) < formula.length()) {
                nChar = formula.charAt(i + 1);
                nextChar = String.valueOf(nChar);
            }


            //System.out.println("current:" + currentChar);
            //System.out.println("next: " + nextChar);

            //System.out.println(String.valueOf(Character.isDigit(cChar)));

            if (!Character.isDigit(cChar)) {
                if (nChar != null) {

                    // is a digit
                    if (Character.isDigit(nChar) && Character.isLetter(cChar)) {
                        hm.put(cChar,Integer.valueOf(nextChar));
                    } else if (Character.isLetter(cChar)) {
                        // not a digit


                        String combinedChars = String.valueOf(cChar);

                        int j = i;


                        // combine chars until next uppercase
                        while (Character.isLowerCase(formula.charAt(j + 1))) {
                            //System.out.println( "NEXT: " + formula.charAt(j + 1));
                            combinedChars += formula.charAt(j + 1);
                            j++;
                        }

                        //System.out.println( "COMBINED: " + combinedChars);

                        if (Character.isUpperCase(combinedChars.charAt(0)))
                            hm.put(combinedChars,1);
                    }
                } else {
                    if (Character.isLetter(cChar))
                        hm.put(cChar,1);
                }

            }

        }

        //System.out.println(hm);
        return hm;
    }


    public static String openBrackets(String input) {
        System.out.println(input.contains("("));

        String originalString = input;

        //	while (originalString.contains("(") || originalString.contains("[") || originalString.contains("{") ) {


//
        //}







        return "";
    }


    public static String testing(String originalString) {
        String output = "";

        // replace all brackets
        String newString = originalString
                .replace("[", "(")
                .replace("{", "(")
                .replace("]", ")")
                .replace("}", ")");


        int lastOpenBracket = newString.lastIndexOf("(");
        int firstCloseBracket = newString.indexOf(")");
        System.out.println("newString: " + newString);

        // get multiplier

        int multiplier = 1;

        if ((firstCloseBracket + 1) >= newString.length()) {
            multiplier = 1;
        } else {
            multiplier = Integer.parseInt(String.valueOf(newString.charAt(firstCloseBracket + 1)));
        }

        System.out.println("multiplier: " + multiplier);

        // get string inside brackets
        String mySubStr = newString.substring(lastOpenBracket + 1, firstCloseBracket);

        System.out.println("mySubStr: " + mySubStr);

        Map newMap = getAtoms(mySubStr);

        System.out.println(newMap);


        // Get a set of the entries
        Set set = newMap.entrySet();

        // Get an iterator
        Iterator i = set.iterator();


        String convertedString = "";

        // Display elements
        while(i.hasNext()) {
            Map.Entry<String, Integer> me = (Map.Entry)i.next();
            System.out.print(String.valueOf(me.getKey()) + ": ");
            System.out.println(me.getValue());

            int result = me.getValue() * multiplier;

            //System.out.println("result: " + result);

            me.setValue(result);


            System.out.print(String.valueOf(me.getKey()) + ": ");
            System.out.println(me.getValue());

            convertedString += String.valueOf(me.getKey()) + String.valueOf(me.getValue());

        }

        System.out.println(convertedString);

        String mySubStr2 = "(" + mySubStr + ")" + multiplier;

        String newerString = newString.replace(mySubStr2,convertedString);

        System.out.println(newerString);

        newString = newerString;


        return output;
    }
}
