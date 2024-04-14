package Sliding_Window;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_2444 {
    public static void main(String[] args) {
        /**
         * You are given an integer array nums and two integers minK and maxK.
         *
         * A fixed-bound subarray of nums is a subarray that satisfies the following conditions:
         *
         * The minimum value in the subarray is equal to minK.
         * The maximum value in the subarray is equal to maxK.
         * Return the number of fixed-bound subarrays.
         *
         * A subarray is a contiguous part of an array
         */

        int []a ={1,3,5,2,7,5};
        int minK = 1;
        int maxK = 5;
        System.out.println(call(a ,minK , maxK));
    }
    public static long call(int[]a , int minK , int maxK){
      int maxK_position = -1;
      int minK_position = -1;
      int cultPrit_position = -1;

      long count = 0;
      for(int i = 0 ; i<a.length ; i++){
          if(a[i] < minK || a[i] > maxK) cultPrit_position = i;

          if(a[i] == maxK ) maxK_position = i;

          if(a[i] == minK) minK_position = i;

          int smaller = Math.min(minK_position , maxK_position);
          int temp = smaller - cultPrit_position;
          count+= temp<=0 ? 0 : temp;
      }
      return count;
    }
}
