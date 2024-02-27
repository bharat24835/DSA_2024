package Prefix_Sum;

import java.util.HashMap;
import java.util.Map;

public class Maximum_Good_SubArray_Sum {
    public static void main(String[] args) {
        int[]a = {-1,3,2,4,5};
        int k = 3;
        System.out.println(call(a, k));
    }
    public static long call(int[]a , int k){
        // first of all we need to find prefix sum
        int n = a.length;
        long[]prefix   = new long[n];
        prefix[0] = a[0];
        for(int i = 1 ; i<n ; i++){
            prefix[i] = prefix[i-1] + a[i];
        }

        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;

        for(int j = 0 ; j<n ; j++){
            int ele = a[j];

            int t1 = ele - k;
            int t2 = ele + k;

            // now check condtion and perform operaiton
            if(Math.abs(t1 - ele) == k && map.containsKey(t1)){
                int i = map.get(t1);
                int sum = (int) (prefix[j] - (i> 0? prefix[i-1]:0 ));
                max = Math.max(max, sum);
            }
            if(Math.abs(t2 - ele) == k && map.containsKey(t2)){
                int i = map.get(t2);
                int sum = (int) (prefix[j] - (i> 0? prefix[i-1]:0 ));
                max = Math.max(max, sum);
            }
            if(!map.containsKey(ele))
            map.put(ele , j);
        }
        return max==Integer.MIN_VALUE ? 0 :max;



    }
}
