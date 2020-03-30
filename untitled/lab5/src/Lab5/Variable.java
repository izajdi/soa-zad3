package Lab5;

import Lab5.Node;

public class Variable extends Node {
    String name;
    double value;
    Variable(String _name){
        this.name = _name;
    }
    void setValue(double _value){
        this.value = _value;
    }
    @Override
    double evaluate(){
        return sign* value;
    }
    @Override
    public String toString(){
        StringBuilder s1 = new StringBuilder();
        if(sign<0)s1.append("-");
        s1.append(name);
        return s1.toString();
    }

}
