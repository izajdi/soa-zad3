package Lab5;

import Lab5.Node;

public class Power extends Node {
    double p;
    Node arg;
    Power(double _p, Node _arg){
        this.p = _p;
        this.arg = _arg;
    }
    @Override
    double evaluate(){
        double argVal = arg.evaluate();
        return Math.pow(argVal, p);
    }
    int getArguementsCount(){ return 1; }

    @Override
    public String toString(){
        StringBuilder s1 = new StringBuilder();
        if(sign <0)s1.append("-");
        int argSign = sign;
        int argCounts = arg.getArgumentsCount();
        boolean checker = false;
        if(argSign <0 || argCounts >1)checker = true;
        if(checker)s1.append("(");
        String argString = arg.toString();
        s1.append(argString);
        if(checker)s1.append(")");
        s1.append("^");
        s1.append(p);
        return s1.toString();


    }

}
