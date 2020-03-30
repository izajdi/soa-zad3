package Lab5;

public class Constant extends Node {
    private double value;
    Constant(double _value){
        if(_value>0){
            this.sign = 1;
            this.value = _value;
        }
        else{
            this.sign = -1;
            this.value = -_value;
        }
    }
    @Override
    double evaluate(){
        return sign* value;
    }

    double getValue(){ return value;}

    @Override
    public String toString(){
        StringBuilder s1 = new StringBuilder();
        if(sign <0)s1.append("-");
        s1.append(value);
        return s1.toString();
    }




}
