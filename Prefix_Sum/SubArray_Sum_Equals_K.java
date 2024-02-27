package Prefix_Sum;

import java.util.HashMap;
import java.util.Map;

public class SubArray_Sum_Equals_K {
    public static void main(String[] args) {
        int[]a =  {1,1,1};
        int k = 2;
        System.out.println(subarraySum(a,k));
    }
    public static int subarraySum(int[] a, int k) {


        // Prefix sun
        int sum =0;
        int count =0;
        Map<Integer, Integer> map = new HashMap<>();
        // Sum , Count
        map.put(0,1);

        for(int i =0; i <a.length ; i++){
            sum+=a[i];
            int target = sum - k;

            if(map.containsKey(target)){
                count+=map.get(target);
            }
            map.put(sum , map.getOrDefault(sum , 0 ) + 1);

        }
        return count;

    }
}
