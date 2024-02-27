package Prefix_Sum;

import java.util.HashMap;
import java.util.Map;

public class SubArray_Sum_Divisile_By_K {
    public static void main(String[] args) {
        int[]a = {-1,2,9};
        int k = 2;
        System.out.println(call(a, k));
        System.out.println(call1(a, k));
    }
    public static int call(int[]a, int k){
        // Brute Force
        int count = 0;
        for(int i =0; i<a.length; i++){
            int sum = 0;
            for(int j = i ; j<a.length; j++){
                sum+=a[j];
                if(sum%k == 0) count++;

            }
        }
        return count;
    }
    public static int call1(int []a, int k){
        // Prfix sum
        int sum = 0 ;
        int count =0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        for(int i = 0; i<a.length ; i++){
            sum+=a[i];
            int temp = sum;


            while(temp%k < 0){
                temp+=k;
            }
            int mod = temp%k;

            if(map.containsKey(mod)){
                count+=map.get(mod);

            }

            map.put(mod, map.getOrDefault(mod, 0)+1);


        }
        return count;

    }
}
