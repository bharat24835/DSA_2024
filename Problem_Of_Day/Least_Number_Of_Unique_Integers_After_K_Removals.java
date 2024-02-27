package Problem_Of_Day;

import java.util.*;

public class Least_Number_Of_Unique_Integers_After_K_Removals {
    public static void main(String[] args) {
        int[]a = {4,3,1,1,3,3,2};
        int k = 3;
        System.out.println(call(a, k));
    }
    public  static int call(int[] a, int k){
        PriorityQueue<Pair>pq = new PriorityQueue<>((x,y)-> x.count - y.count);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i<a.length; i++){
            map.put(a[i] , map.getOrDefault(a[i], 0) +1);
        }

        for(int key: map.keySet()){
            pq.add(new Pair(key , map.get(key)));
        }
        System.out.println(pq.peek().count + " " + pq.peek().num);

        int temp = k;
        while(temp > 0){
            if(k == 0)return pq.size();
            Pair item = pq.poll();
            int count  =item.count;
            int num  = item.num;
            if( count <= k) k -=count;
            else if(count >k )return pq.size()+1;

        }
     return  a.length-k;
    }
    public static class Pair{
        public int num ;
        public int count;
        Pair(int a, int b){
            this.num = a;
            this.count = b;
        }

    }

}
