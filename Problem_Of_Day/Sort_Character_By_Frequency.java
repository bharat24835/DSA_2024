package Problem_Of_Day;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collector;

public class Sort_Character_By_Frequency {
    public static void main(String[] args) {
        String s  = "tree";
        System.out.println(call(s));
    }
    public static String call(String s){
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0 ; i<s.length(); i++){
            char temp = s.charAt(i);
            map.put(temp, map.getOrDefault(temp, 0)+1);
        }

        // now transform this map intp PQ;
        PriorityQueue<Pair>pq = new PriorityQueue<>(new customComparator());
        for(Character key :map.keySet()){
            pq.add(new Pair(key, map.get(key)));
        }

        StringBuilder ans = new StringBuilder();
        while(!pq.isEmpty()){
            Pair temp = pq.poll();
            char c = temp.c;
            int count = temp.count;
            while(count!= 0){
                ans.append(c);
                count--;
            }
        }
        return ans.toString();
    }

   public static class  customComparator implements Comparator<Pair>{
        public int compare(Pair p1 , Pair p2){
               if(p1.count < p2.count)
                   return 1;
               else if (p1.count > p2.count) {
                   return -1;
               }
               return 0;
        }
    }
    public static class Pair{
        char c ;
        int count;
        Pair(char c, int b){
            this.c = c;
            this.count = b;
        }
    }

}

