import java.util.*;
import java.math.*;

public class PaginationHelper<I> {
    private List<I> list;
    private int itemsPerPage;
    public PaginationHelper(List<I> collection, int itemsPerPage){
        this.list = collection;
        this.itemsPerPage = itemsPerPage;
    }

    public int itemCount(){
        return list.size();
    }

    public int pageCount(){
        int numberOfItem = this.itemCount();
        while(numberOfItem % itemsPerPage != 0){
            numberOfItem++;
        }
        return numberOfItem/itemsPerPage;
    }

    public int pageItemCount(int index){
        if((index + 1) > this.pageCount()){
            return -1;
        }
        if((index + 1) < this.pageCount()){
            return itemsPerPage;
        }
        return this.itemCount() - (index * itemsPerPage);

    }

    public int pageIndex(int index){
        if(index < 0) return -1;
        if(index > this.itemCount() - 1){
            return -1;
        }
        while(index % itemsPerPage != 3){
            index++;
        }
        return (index - 3)/itemsPerPage;
    }

    public static String longToIP(long ip){
        StringBuilder octet1 = new StringBuilder();
        StringBuilder octet2 = new StringBuilder();
        StringBuilder octet3 = new StringBuilder();
        StringBuilder octet4 = new StringBuilder();
        int counter = 0;
        int reverseCounter = 31;
        Double ipInDouble = (double)ip;
        for(int i=0; i<32; i++){
            double currentBit = Math.pow(2, reverseCounter);
            if(ipInDouble < currentBit){
                if(counter >= 0 && counter <8){
                    octet1.append(0);
                }
                if(counter >= 8 && counter <16){
                    octet2.append(0);
                }
                if(counter >= 16 && counter <24){
                    octet3.append(0);
                }
                if(counter >= 24 && counter <32){
                    octet4.append(0);
                }
            }
            if(ipInDouble >= currentBit){
                ipInDouble -= currentBit;
                if(counter >= 0 && counter <8){
                    octet1.append(1);
                }
                if(counter >= 8 && counter <16){
                    octet2.append(1);
                }
                if(counter >= 16 && counter <24){
                    octet3.append(1);
                }
                if(counter >= 24 && counter <32){
                    octet4.append(1);
                }
            }
            counter++;
            reverseCounter--;
        }
        return octetBitstoIp(octet1.toString()) + "." + octetBitstoIp(octet2.toString()) + "." + octetBitstoIp(octet3.toString()) + "." + octetBitstoIp(octet4.toString());
    }

    public static String octetBitstoIp(String s1){
        int reverseCounter = 7;
        int result =0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) == '1'){
                result += Math.pow(2, reverseCounter);
            }
            reverseCounter--;
        }
        return Integer.toString(result);
    }



    public static void main(String[] args){
        /*List<Character> list = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f');
        PaginationHelper<Character> ph = new PaginationHelper<>(list, 4);
        System.out.println(Double.NaN == Double.NaN);
        if(new boolean[true] == new boolean[true]) System.out.println("Udalo sie:)");*/
        long aa = 2149583361L;
        System.out.println(aa>>16&0xFF);

    }

}
