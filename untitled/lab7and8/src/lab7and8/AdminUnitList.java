package lab7and8;


import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class AdminUnitList {
    List<AdminUnit> units = new ArrayList<>();
    Map<Long, AdminUnit> id = new HashMap<>();
    Map<AdminUnit, Long> parentId = new HashMap<>();
    Parser reader;

    void read(String filename, String delimiter) throws IOException {
        this.reader = new Parser(filename, delimiter);
        reader.parseFile();
        for(int i=1; i<reader.getDates().size(); i++){
            AdminUnit admmin_unit = new AdminUnit(reader.getDates().get(i));
            units.add(admmin_unit);
            id.put(Long.parseLong(reader.getDates().get(i).get(0)), admmin_unit);
            parentId.put(admmin_unit, Long.parseLong(reader.getDates().get(i).get(1)));
        }
    }

    void add(AdminUnit unit){
        units.add(unit);
    }

    public List<AdminUnit> getUnits(){
        return units;
    }

    void list(PrintStream out, int offset, int limit){
        for(int i=offset; i<limit; i++){
            out.println(units.get(i).toString());
        }
    }
    AdminUnitList selectByName(String pattern, boolean regex){
        AdminUnitList result = new AdminUnitList();
        if(regex){
            for(int i=0; i<units.size(); i++){
                if(units.get(i).getName().matches(pattern)){
                    result.add(units.get(i));
                }
            }
        }
        else{
            for(int i=0; i<units.size(); i++){
                if(units.get(i).getName().contains(pattern)){
                    result.add(units.get(i));
                }
            }
        }
        return result;
    }

    AdminUnitList getNeighbours(AdminUnit unit, double maxdistance) {
        AdminUnitList neighbours = new AdminUnitList();
        for (AdminUnit potentialNeighbour : this.units) {
            if (potentialNeighbour.adminLevel == unit.adminLevel && unit != potentialNeighbour) {
                if (unit.adminLevel >= 8) {
                    if (unit.bbox.distanceTo(potentialNeighbour.bbox) < maxdistance)
                        neighbours.units.add(potentialNeighbour);
                } else if (unit.bbox.intersects(potentialNeighbour.bbox))
                    neighbours.units.add(potentialNeighbour);
            }
        }
        return neighbours;
    }
}
