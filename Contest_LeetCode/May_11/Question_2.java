package Contest_LeetCode.May_11;

import java.util.*;

public class Question_2 {
    public static void main(String[] args) {
            int[][] a = {{} , {27,3} , {23,-14} , {-32,-16} ,{-3,26} , {-14,33} };
            String s = "aaabfc";
        System.out.println(call(a , s));
    }
    public static int call(int[][]a , String s){

        Map<Integer , ArrayList<Character>> map = new HashMap<>();
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        Set<Integer>set = new HashSet<>();
        // first of all we need to create distance
        for(int i  = 0 ; i<a.length; i++){
            int ith_index = Math.abs(a[i][0]);
            int jth_index = Math.abs(a[i][1]);


            int max_dist = Math.max(ith_index , jth_index);
            if(!set.contains(max_dist)){
                set.add(max_dist);
                pq.offer(max_dist);
            }

            ArrayList<Character>temp = map.containsKey(max_dist) ? map.get(max_dist) : new ArrayList<>();
            temp.add(s.charAt(i));
            map.put(max_dist , temp);
        }
        int count = 0;
        Set<Character>st = new HashSet<>();
        while(!pq.isEmpty()){

            Integer dist = pq.poll();
            ArrayList<Character>temp = map.get(dist);
            for(int i = 0 ; i<temp.size() ; i++){
                Character c = temp.get(i);
                if(st.contains(temp.get(i))) return count;
                st.add(temp.get(i));
            }
            count+= temp.size();

        }
        return count;
    }
}
