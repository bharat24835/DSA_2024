package Sliding_Window;

import java.util.*;

public class LeetCode_2958 {
    public static void main(String[] args) {
        /**
         * You are given an integer array nums and an integer k.
         *
         * The frequency of an element x is the number of times it occurs in an array.
         *
         * An array is called good if the frequency of each element in this array is less than or equal to k.
         *
         * Return the length of the longest good subarray of nums.
         *
         * A subarray is a contiguous non-empty sequence of elements within an array.
         */

        // Take TreeMap
        int[]a = {5,5,5,5,5,5,5};
        int  k = 4;
        System.out.println(call(a , k));
    }
    public static int call(int[]a , int k){
      //  TreeMap<Integer , Integer> tmap = new TreeMap<>(Collections.reverseOrder());

        Map<Integer, Integer> hmap = new HashMap<>();

        int i = 0;
        int j = 0;
        int ans = 0;

        while(j < a.length){

            // updating jth elemetn count
            hmap.put(a[j] , hmap.getOrDefault(a[j] , 0)+1);

            // shrinking phase , agar shrinking ki conditon aegi , toh voh sirf a[j] elemnet k kaarna aegi
            while(i< a.length && hmap.get(a[j]) > k){
                hmap.put(a[i] , hmap.get(a[i])-1);
                i++;
            }
            ans = Math.max(j-i+1 ,ans);
            j++;


        }
        return ans;

    }

}

