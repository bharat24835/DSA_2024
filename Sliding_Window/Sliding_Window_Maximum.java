package Sliding_Window;

import java.util.*;

public class Sliding_Window_Maximum {
    public static void main(String[] args) {
        int[]a ={1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(call(a, k)));
    }
    public static int[]call(int []a, int k){
        int n = a.length;
        int[]ans = new int[n-k+1];
        PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;  // this pointer for left side of window
        int j = 0;  // this pointer for right side of window
        int p = 0;  // this pointer for ans Array

        while (j <n){
             int item = a[j];
             pq.add(item);


             if(j-i+1 == k){
                 int max = pq.peek();
                 ans[p++] = max;
                 pq.remove(a[i]);
                 i++;
             }
             j++;

        }
        return ans;
    }
}
