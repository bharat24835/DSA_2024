package POD_LEETCODE;

import java.util.*;

public class Straigh_Of_Hands {
    public static void main(String[] args) {
        int[]a = {1,2,3,6,2,3,4,7,8};
        int k  = 3;
        System.out.println(call(a , k));
    }
    public static boolean call(int[]a , int k){
        if(a.length % k != 0 ) return false;
        Arrays.sort(a);
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        Map<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i<a.length ; i++){
            map.put(a[i] , map.getOrDefault(a[i] , 0)+1);
        }

        int i = 0;

        while( i <a.length){
            int prev = -1;

            int j =0;

            while(j < k){
                if(prev == -1){
                    // we need to select the first member of our group
                    if(!pq.isEmpty()){
                        prev = pq.poll();

                    }
                    else{
                        prev = a[i];
                        i++;
                    }
                    int count = map.get(prev);
                    if(count == 0) map.remove(prev);
                    else map.put(prev , count-1);
                }
                else{

                    int required = prev+1;


                }
            }
        }
        return true;
    }
}
