package Array.Medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Reveal_Cards_In_Increasing_Order {
    public static void main(String[] args) {
        int[]a = {17,13,11,2,3,5,7};
        System.out.println(Arrays.toString(call(a)));
    }
    public static int[] call(int[]a){
        int n = a.length;
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        Queue<Integer>q = new LinkedList<>();
        for(int i = 0 ; i<a.length ; i++){
            pq.add(a[i]);
            q.add(i);
        }

        while(!pq.isEmpty() && !q.isEmpty()){
            int index = q.poll();
            int element  = pq.poll();
            a[index] = element;

            if(!q.isEmpty()){
                int i = q.poll();
                q.add(i);
            }
        }




        return a;
    }
}
