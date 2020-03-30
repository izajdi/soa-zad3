package Lab5;

import java.util.*;

public class Sum extends Node {
    List<Node> args = new ArrayList<>();
    Sum() {}
    Sum(Node n1, Node n2){
        args.add(n1);
        args.add(n2);
    }
    Sum add(Node n){
        args.add(n);
        return this;
    }
    Sum add(double c){
        args.add(new Constant(c));
        return this;
    }
    Sum add(double c, Node n){
        Node mul = new Prod(c, n);
        args.add(mul);
        return this;
    }

    @Override
    double evaluate(){
        double result =0;
        for(Node i:args){
            result += i.evaluate();
        }
        return sign*result;
    }
    int getArgumentsCount(){ return args.size();}
    public String toString(){
        StringBuilder s1 = new StringBuilder();
        if(sign<0)s1.append("-");
        s1.append("(");
        for(Node i:args){
            s1.append(i.toString());
            s1.append("+");
        }
        s1.append(")");
        return s1.toString();
    }



}
