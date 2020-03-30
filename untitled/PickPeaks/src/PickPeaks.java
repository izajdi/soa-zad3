import java.util.*;

public class PickPeaks {
    public static Map<String, List<Integer>> getPeaks(int[] arr){
        List<Integer> peaks = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        Map<String, List<Integer>> result = new HashMap<>();
        String s1 = "pos";
        String s2 = "peaks";
        if(arr.length == 0){
            result.put(s1, peaks);
            result.put(s1, values);
            return result;
        }
        for(int i=1; i<arr.length - 1; i++){
            int currentNode = i;
            int currentValue = arr[i];
            boolean checkLeft = false;
            boolean checkRight = false;
            for(int j= currentNode; j> -1; j--){
                if(arr[j] > currentValue){
                    break;
                }
                if(arr[j] < currentValue){
                    checkLeft = true;
                    break;
                }
            }
            for(int x= currentNode; x<arr.length; x++){
                if(arr[x] > currentValue){
                    break;
                }
                if(arr[x] < currentValue){
                    checkRight= true;
                    break;
                }
            }
            if(checkLeft && checkRight){
                peaks.add(currentNode);
            }
        }
        peaks =  popPleatus(peaks, arr);
        for(int i=0; i<peaks.size();i++){
            values.add(arr[peaks.get(i)]);
        }
        String s1 = "pos";
        String s2 = "peak";
        result.put(s1, peaks);
        result.put(s2, values);
        return result;
    }

    public static List<Integer> popPleatus(List<Integer> list, int[] arr){
        List<Integer> result = new ArrayList<>();
        if(!list.isEmpty()){
            result.add(list.get(0));
        }
        for(int i=1; i<list.size(); i++){
            if(arr[list.get(i)] == arr[list.get(i-1)] && list.get(i) == list.get(i-1) + 1){}
            else{
                result.add(list.get(i));
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] arr = new int[]{2,1,3,1,2,2,2,2};
        System.out.println(getPeaks(arr));
    }
}
