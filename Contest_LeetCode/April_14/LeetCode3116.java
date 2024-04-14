package Contest_LeetCode.April_14;

import Practise.Priority_Queue_Comparator;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LeetCode3116 {
    public static void main(String[] args) {
        int[]a = {3,6,9};
        int k = 3;
        System.out.println(call(a , k));
    }

    public static int call(int[]a , int k){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i<a.length ; i++){
            set.add(a[i]);
            pq.add(new Pair(a[i] , a[i]));
        }

        while(!pq.isEmpty()&& true){
            Pair temp = pq.poll();

            while(!pq.isEmpty() && temp.sum == pq.peek().sum ){
               Pair temp2 = pq.poll();

               pq.add(new Pair(temp2.num + temp2.sum , temp2.num));
            }

            k--;
            if(k == 0) return temp.sum;



            pq.add(new Pair(temp.sum+temp.num, temp.num));


        }

       return 0;
    }
    public static class Pair implements Comparable<Pair>{
        int sum;
        int num;
        Pair(int a, int b){
            this.sum = a;
            this.num = b;

        }

        public int compareTo(Pair temp){
            return this.sum - temp.sum;
        }

    }


}
