package Prefix_Sum;

import java.util.HashMap;
import java.util.Map;

public class Contigous_Array {
    public static void main(String[] args) {
        int[]a = {0,1};
        System.out.println(call(a));
    }
    public static int call(int[]a){
//        Given a binary array nums,
//        return the maximum length of a contiguous subarray with an equal number of 0 and 1
        int ans = 0;
        int sum = 0 ;
        // sum , index
        Map<Integer , Integer>map = new HashMap<>();

        for(int i = 0 ; i<a.length ; i++){
            int item = a[i]==0 ? -1 : a[i];

            sum+=item;
            int target = sum;

            if(target == 0 ){
                ans = Math.max(ans  , i+1);
            }

            if(map.containsKey(target)){
                int index = map.get(target);
                ans = Math.max(ans , i - index );
            }
            if(!map.containsKey(sum))
            map.put(sum , i);

        }
        return ans;
    }
}
