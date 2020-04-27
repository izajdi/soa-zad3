import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneDir {
    public static String phone(String strng, String num){
        List<List<String>> phoneBook = makePhoneBook(strng);
        String result = "";
        int counter = 0;
        for(int i=0; i<phoneBook.size(); i++){
            if(num.equals(phoneBook.get(i).get(0))){
                String str = String.format("Phone => %s, Name => %s, Address => %s", phoneBook.get(i).get(0), makeName(phoneBook.get(i).get(1)), makeAddress(phoneBook.get(i).get(2)).stripLeading());
                counter++;
                result +=str;
            }
        }
        if(counter == 0){
            return String.format("Error => Not found: %s", num);
        }
        if(counter == 1){
            return result;
        }
        return String.format("Error => Too many people: %s", num);
    }

    public static List<List<String>> makePhoneBook(String str){
        List<List<String>> alist = new ArrayList<>();
        String[] arr = str.split("\n");
        for(int i=0; i<arr.length; i++){
            List<String> helperList = new ArrayList<>();
            arr[i] = arr[i].replaceAll("[\\W&&[^\\<\\>\\_\\-\\s\\.\\']]", "");
            Pattern pattern1 = Pattern.compile("(?<phoneNumber>\\d*\\-\\d{3}\\-\\d{3}\\-\\d{4})");
            Pattern pattern2 = Pattern.compile("(?<name>\\<\\D*\\>)");
            Matcher m = pattern1.matcher(arr[i]);
            if(m.find()){
                helperList.add(m.group("phoneNumber"));
            }
            else helperList.add("");
            m = pattern2.matcher(arr[i]);
            if(m.find()){
                helperList.add(m.group("name"));
            }
            else helperList.add("");
            arr[i] = arr[i].replaceAll(helperList.get(0), "");
            arr[i] = arr[i].replaceAll(helperList.get(1), "");
            helperList.add(arr[i]);
            alist.add(helperList);
        }
        return alist;
    }

    private static String makeAddress(String str){
        StringBuilder result = new StringBuilder();
        String id = "";
        str = str.replaceAll("\\_", " ");
        Pattern pattern1 = Pattern.compile("(?<number>\\s\\d*)");
        Pattern pattern2 = Pattern.compile("(?<street>[\\w&&\\D]+[[\\s]*[\\w&&\\D][\\.]?]*)");
        Pattern pattern3 = Pattern.compile("(?<id>\\w*\\-\\d*)");
        Matcher m = pattern1.matcher(str);
        if(m.find()){
            result.append(m.group("number"));
        }
        m = pattern3.matcher(str);
        if(m.find()){
            str = str.replaceAll(m.group("id"), "");
            id = m.group("id");
        }
        m = pattern2.matcher(str);
        if(m.find()){
            result.append(" ").append(m.group("street").stripTrailing().replaceAll("\\s{2,}", " "));
        }
        result.append(" ").append(id);
        String res = result.toString();
        return res.stripLeading().stripTrailing();
    }

    private static String makeName(String str){
        return str.substring(1, str.length() - 1);
    }

    public static void main(String[] args){
        String dr = "/+1-541-754-3010 156 Alphand_St. <J Steeve>\n 133, Green, Rd. <E Kustur> NY-56423 ;+1-541-914-3010\n"
                + "+1-541-984-3012 <P Reed> /PO Box 530; Pollocksville, NC-28573\n :+1-321-512-2222 <Paul Dive> Sequoia Alley PQ-67209\n"
                + "+1-741-984-3090 <Peter Reedgrave> _Chicago\n :+1-921-333-2222 <Anna Stevens> Haramburu_Street AA-67209\n"
                + "+1-111-544-8973 <Peter Pan> LA\n +1-921-512-2222 <Wilfrid Stevens> Wild Street AA-67209\n"
                + "<Peter Gone> LA ?+1-121-544-8974 \n <R Steell> Quora Street AB-47209 +1-481-512-2222\n"
                + "<Arthur Clarke> San Antonio $+1-121-504-8974 TT-45120\n <Ray Chandler> Teliman Pk. !+1-681-512-2222! AB-47209,\n"
                + "<Sophia Loren> +1-421-674-8974 Bern TP-46017\n <Peter O'Brien> High Street +1-908-512-2222; CC-47209\n"
                + "<Anastasia> +48-421-674-8974 Via Quirinal Roma\n <P Salinger> Main Street, +1-098-512-2222, Denver\n"
                + "<C Powel> *+19-421-674-8974 Chateau des Fosses Strasbourg F-68000\n <Bernard Deltheil> +1-498-512-2222; Mount Av.  Eldorado\n"
                + "+1-099-500-8000 <Peter Crush> Labrador Bd.\n +1-931-512-4855 <William Saurin> Bison Street CQ-23071\n"
                + "<P Salinge> Main Street, +1-098-512-2222, Denve\n"+ "<P Salinge> Main Street, +1-098-512-2222, Denve\n";
        System.out.println(phone(dr, "48-421-674-8974"));
        System.out.println(phone(dr, "1-921-512-2222"));
        System.out.println(phone(dr, "1-498-512-2222"));

        for(int i=0; i<makePhoneBook(dr).size(); i++){
            System.out.println(makePhoneBook(dr).get(i));
        }








    }

}
