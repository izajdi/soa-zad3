public class Spin {
    public static String SpinWords(String formula){
        String[] spiltedFormula = formula.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i=0; i<spiltedFormula.length; i++){
            if(spiltedFormula[i].length() > 4){
                for(int j=spiltedFormula[i].length() - 1; j> -1; j--){
                    result.append(spiltedFormula[i].charAt(j));
                }
            }
            else{
                result.append(spiltedFormula[i]);
            }
            if(spiltedFormula.length != i + 1) result.append(" ");
        }
        return result.toString();
    }
    public static void main(String[] args){
        String s1 = "Welcome";
        System.out.println(SpinWords(s1));
    }
}
