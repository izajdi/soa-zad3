package Lab5;

import java.util.*;

public class Prod extends Node {
    List<Node> args = new ArrayList<>();
    Prod() {}
    Prod(Node n1){
        args.add(n1);
    }
    Prod(double c){
        args.add(new Constant(c));
    }
    Prod(Node n1, Node n2){
        args.add(n1);
        args.add(n2);
    }
    Prod(double c, Node n){
        args.add(new Constant(c));
        args.add(n);
    }
    Prod mul(Node n){
        args.add(n);
        return this;
    }
    Prod mul(double c){
        args.add(new Constant(c));
        return this;
    }
    @Override
    double evaluate(){
        double result = 1;
        for(Node i:args){
            result *= i.evaluate();
        }
        return sign* result;
    }
    public String toString(){
        StringBuilder s1 = new StringBuilder();
        if(sign<0)s1.append("-");
        s1.append("(");
        for(Node i :args){
            s1.append(i.toString());
            s1.append("*");
        }
        s1.append(")");
        return s1.toString();

    }



}
