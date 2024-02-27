package Array.Easy;

import java.util.HashMap;
import java.util.Map;

public class Longest_SubArray_With_Sum_K {
    public static void main(String[] args) {
//        int[]a = {1,2,3,1,1,1,1,4,2,3};
        int[]a = {1,-1,1};

        int k  = 1;
        System.out.println("Answer By Hashing :- " + call(a, k));
        System.out.println("Answer By Sliding Window :- " + call2(a, k)) ;
    }
    public static int call(int[]a, int k){
        // Hashing
        Map<Integer, Integer>map = new HashMap<>();
        int sum =0 ;
        int max = 0;

        for(int i = 0 ;i<a.length; i++){

            // adding sum
            sum+=a[i];

            // sum == k
            if(sum == k) max = Math.max(max, i+1);

            // finding the remaining sum
            int rem= sum - k;
            if(map.containsKey(rem)){
                int l  = i - map.get(rem);
                max = Math.max(max, l);
            }

            // updating sum in map with ignoring the zeros problem
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return max;
    }

    public static int call2(int[]a, int k){
        // Sliding window
        int sum = 0;
        int max = 0;
        int i  =0;
        int j = 0;

        while(j < a.length){
            sum+=a[i];

            if(sum == k ){
                max  = Math.max(max, j-i+1);
            }

            while(i<=j && sum>k){
                // shringk left pointer
                sum-=a[i];
                i++;
            }
            j++;


        }
        return max;
    }

}
