package POD_LEETCODE;

import java.util.Collections;
import java.util.PriorityQueue;

public class Maximizie_Happiness_Of_Children {
    public static void main(String[] args) {
        int[]a = {12,1,42};
        int k = 3;

        System.out.println(call(a , k));
    }
    public static int call(int[]a ,  int k ){
        PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0  ; i<a.length ; i++){
            pq.offer(a[i]);
        }

        int ans = 0;
        int count = 0;
        while(!pq.isEmpty() && k != 0){
            Integer happiness = pq.poll();
            if(happiness - count <=0) break;
            ans += happiness - count;
            k--;
            count++;
        }
        return ans;
    }
}
