import java.util.*;

public class SumOfK {
    public static Integer chooseBestSum(int t, int k, List<Integer> ls){
        int[] tab = new int[k];
        for(int i=0; i<k; i++){
            tab[i] = i;
        }
        int result = value(tab, ls);
        if(result > t){
            result =0;
        }
        while(true){
            int best = value(tab, ls);
            if(best <= t && best > result){
                result = best;
            }
            if(increment(tab, ls.size())) break;
        }
        return result;
    }


    private static boolean increment(int[] idx, int range) {
        for(int i=idx.length -1; i>=0; i--){
            idx[i]++;
            if(idx[i] <= range - idx.length + i){
                for(int j=i+1; j<idx.length; j++){
                    idx[j] = idx[j-1] + 1;

                }
                return false;
            }
        }
        return true;
    }

    private static Integer value(int []idx, List<Integer> list){
        int result =0;
        for(int i=0; i<idx.length; i++){
            result += list.get(idx[i]);
        }
        return result;
    }

    public static void main(String []arg){
        List<Integer> ts = new ArrayList<>(Arrays.asList(50, 55, 56, 57, 58));
        System.out.println(chooseBestSum(163, 3, ts));
    }
}
