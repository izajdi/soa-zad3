package Lab5;

public class Main
{
    public static void main(String[] arg){
        double d =5;
        Node n1 = new Constant(d);
        Variable n2 = new Variable("x");
        n2.setValue(d);
        Node sum = new Sum(n1, n2);
        String result = null;
        result = sum.toString();
        System.out.println(result);

    }
}
