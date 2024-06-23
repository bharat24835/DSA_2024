package Sliding_Window;

import java.util.Collections;
import java.util.PriorityQueue;

public class Longest_Continuous_Subarray_With_Absolute_Diff_Less_Than_or_Equal_to_Limit {
    public static void main(String[] args) {
        int[]a ={4,2,2,2,4,4,2,2};
        int limit = 0;
        System.out.println(call(a , limit));
    }
    public static int call(int[]a , int limit){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
       int ans = 0;

       int i = 0;
       int j = 0;


       while(j < a.length){
           // add jth element
           maxHeap.add(a[j]);
           minHeap.add(a[j]);

           while( i < a.length && i<= j && Math.abs(maxHeap.peek() - minHeap.peek()) > limit){
               // shrink the window size
               int front_element  = a[i];
               minHeap.remove(front_element);
               maxHeap.remove(front_element);
               i++;
           }

           ans = Math.max(j-i+1 , ans);
           j++;


       }

        return ans;
    }
}
