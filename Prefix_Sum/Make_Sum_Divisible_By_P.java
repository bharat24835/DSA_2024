package Prefix_Sum;

import java.util.HashMap;
import java.util.Map;

public class Make_Sum_Divisible_By_P {
    public static void main(String[] args) {
        int[]a = {1,2,3};
        int p =7;

        System.out.println(call(a, p));
    }
    public static int call(int[]a, int k){
        long sum =0;
        int n = a.length;
        for(int i =0; i<n ; i++ ){
            sum+=a[i];
        }
        if(sum % k == 0)return 0;
         int target = (int) (sum % k);
        Map<Integer, Integer > map= new HashMap<>();
        // Sum , Index
        map.put(0,-1);

        // now we need to find the that subarry whose sum is "sum"
        int ans  = Integer.MAX_VALUE;
        sum = 0 ;
        for(int i =0 ; i<n ; i++){
            sum+=a[i];

            int temp = (int) ((sum - target)%k);

            if(map.containsKey(temp)){
                int index = map.get(temp);
                ans = Math.min(ans, i-index);
            }
            map.put((int) (sum%k), i );
        }
        return ans>=n ? -1: ans;

    }
}
