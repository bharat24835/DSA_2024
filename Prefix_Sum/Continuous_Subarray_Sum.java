package Prefix_Sum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Continuous_Subarray_Sum {
    public static void main(String[] args) {
        int[]a = {0,0};
        int k  = 1;
        System.out.println(call2(a,k));
    }
    public static boolean call(int[]a, int k ){
        Set<Integer>set = new HashSet<>();
        // default case for whole array
        set.add(0);

        // subarray that end at index column 'i'
        int sum = 0 ;
        for(int i = 0 ; i<a.length ;i++ ){
            sum+=a[i];

            int target = (sum - k)%k  ;
            if(target>=0 && set.contains(target%k)) return true;

            set.add(sum%k);
        }
        return false;
    }
    public static boolean call2(int[]a , int k){
        Map<Integer, Integer> map = new HashMap<>();
        // default case for whole array
        map.put(0,-1);

        // subarray that end at index column 'i'
        int sum = 0 ;
        for(int i = 0 ; i<a.length ;i++ ){
            sum+=a[i];

            int target = (sum - k)%k  ;
            if(target>=0 && map.containsKey(target%k)){
                if(Math.abs(map.get(target%k) - i) > 1) return true;
            }
            if(!map.containsKey(sum%k));
            map.put(sum%k, i);
        }
        if(sum == 0 && a.length >1) return  true;
        return false;
    }
}
