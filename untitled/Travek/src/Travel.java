import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Travel {
    ArrayList<Integer> alist = new ArrayList<Integer>();
    public static void travel(String r, String zipcode){
        Pattern cpattern = Pattern.compile("(\\d+)\\s((\\w+\\.?\\s)+)" + zipcode);
        Matcher macther;
        StringBuilder numbers = new StringBuilder();
        StringBuilder street = new StringBuilder();


        ArrayList<String> alist = new ArrayList<>(Arrays.asList(r.split(",")));
        for(String x: alist){
            if(x.endsWith(zipcode)){
                macther = cpattern.matcher(x);
                while(macther.find()){
                    System.out.println(macther.group(1).trim());
                    System.out.println(macther.group(2).trim());

                }
            }
        }

        
    }

    public void fill(){
        this.alist.add(3);
        this.alist.add(2);
    }

    public ArrayList<Integer> getAlist(){
        return this.alist;
    }
    public static void main(String[] args){
        /*String r = "123 Main Street St. Louisville OH 43071,432 Main Long Road St. Louisville OH 43071,786 High Street Pollocksville NY 56432";
        String zipcode = "OH 43071";
        travel(r, zipcode);*/
        Travel travel = new Travel();
        travel.fill();
        travel.getAlist().remove(1);
        LocalDate localdate = LocalDate.now().plusDays(2);
        System.out.println(localdate - LocalDate.EPOCH.now());

    }
}
