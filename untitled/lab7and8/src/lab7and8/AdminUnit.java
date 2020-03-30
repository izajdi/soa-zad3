package lab7and8;

import java.util.*;

public class AdminUnit {
    String name;
    int adminLevel;
    double popluation;
    double area;
    double density;
    AdminUnit parent;
    BoundingBox bbox;

    public AdminUnit(List<String> dates){
        this.setName(dates.get(2));
        this.setAdminLevel(dates.get(3));
        this.setArea(dates.get(5));
        this.setDensity(dates.get(6));
        bbox = new BoundingBox();

        double x1 = Double.parseDouble(dates.get(7));
        double y1 = Double.parseDouble(dates.get(8));
        bbox.addPoint(x1, y1);
        double x2 = Double.parseDouble(dates.get(9));
        double y2 = Double.parseDouble(dates.get(10));
        bbox.addPoint(x2, y2);
        double x3 = Double.parseDouble(dates.get(11));
        double y3 = Double.parseDouble(dates.get(12));
        bbox.addPoint(x3, y3);
        double x4 = Double.parseDouble(dates.get(13));
        double y4 = Double.parseDouble(dates.get(14));
        bbox.addPoint(x4, y4);


    }
    void setName(String s1){
        if(s1.isEmpty()){
            this.name = " ";
        }
        else{
            this.name = s1;
        }
    }
    void setAdminLevel(String s1){
        if(s1.isEmpty()){
            this.adminLevel = 0;
        }
        else{
            this.adminLevel = Integer.parseInt(s1);
        }
    }
    void setArea(String s1){
        if(s1.isEmpty()){
            this.area = 0.0;
        }
        else{
            this.area = Double.parseDouble(s1);
        }
    }
    void setDensity(String s1){
        if(s1.isEmpty()){
            this.density = 0.0;
        }
        else{
            this.density = Double.parseDouble(s1);
        }
    }

    String getName(){
        return name;
    }


    @Override
    public String toString(){
        StringBuilder s1 = new StringBuilder();
        s1.append("name: ");
        s1.append(name);
        s1.append("; ");
        s1.append("adminLevel: ");
        s1.append(adminLevel);
        s1.append("; ");
        s1.append("area: ");
        s1.append(area);
        s1.append("; ");
        s1.append("density: ");
        s1.append(density).append(" ");
        s1.append(bbox.toString());
        return s1.toString();
    }
}
