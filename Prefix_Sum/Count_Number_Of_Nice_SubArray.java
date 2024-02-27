package Prefix_Sum;

import java.util.HashMap;
import java.util.Map;

public class Count_Number_Of_Nice_SubArray {
    public static void main(String[] args) {
        int[]a = {1,1,2,1,1};
        int k = 3;
        System.out.println(call(a, k));
    }
    public static int call(int[]a, int k){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        int sum  = 0;

        for(int i = 0 ; i<a.length; i++){
            if(a[i]%2 != 0) sum++;
            int target = sum - k;
            if(map.containsKey(target)){
                count+=map.get(target);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
