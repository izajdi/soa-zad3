import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class class1 {
    public static Map<String, Integer> getAtomsWithoutBracket(String formula){
        Map<String, Integer> result = new HashMap<>();
        for(int i=0; i<formula.length(); i++){
            Character cchar = formula.charAt(i);
            StringBuilder sb = new StringBuilder();

            Character nchar = null;

            if(formula.length() != i + 1){
                nchar = formula.charAt(i + 1);
            }

            if(Character.isUpperCase(cchar)) {       //first UpperCase is one atom
                sb.append(cchar);
                if (nchar == null) {                //if there isn't next char in formula than, just put 1
                    result.put(sb.toString(), 1);
                }
                else{
                    int j = i + 1;
                    StringBuilder counter = new StringBuilder();
                    while(formula.length() != j && !Character.isUpperCase(formula.charAt(j))){ //finding counter in atom
                        if(Character.isLowerCase(formula.charAt(j))){
                            sb.append(formula.charAt(j));
                        }
                        if(Character.isDigit(formula.charAt(j))){
                            counter.append(formula.charAt(j));
                        }
                        j++;
                    }
                    if(counter.toString().isEmpty()){
                        result.put(sb.toString(), 1);
                    }
                    else{
                        int a = Integer.parseInt(counter.toString());
                        result.put(sb.toString(), a);
                    }
                }
            }

        }
        return result;
    }

    private static List<Matcher> extractMinimalGroup(String formula) {
        List<Matcher> matchers = Arrays.asList(
                Pattern.compile(".*([\\{](.*?)[\\}]([0-9]*)?).*").matcher(formula),
                Pattern.compile(".*([\\[](.*?)[\\]]([0-9]*)?).*").matcher(formula),
                Pattern.compile(".*([\\(](.*?)[\\)]([0-9]*)?).*").matcher(formula)
        );
        return matchers;

    }

    public static void main(String[] args){
        String s1 = "O2{K4[ON(SO3)2]2}";
        List<Matcher> matchers = extractMinimalGroup(s1);
        System.out.println("Hello Word");
    }
}
