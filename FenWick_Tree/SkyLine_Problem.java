package FenWick_Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import static Array.Medium.MIn_Arrow_To_Burst_Ballons.call;

public class SkyLine_Problem {
    public static void main(String[] args) {
        int[][]buildings = {{2,9,10} , {3,7,15} , {5,12,12} , {15,20,10} , {19,24,8}};
        List<List<Integer>> temp = call(buildings);
        System.out.println(temp);
    }
    public static List<List<Integer>> call(int[][]buildings){
        List<Pair>list  = new ArrayList<>();
        for(int i = 0 ; i<buildings.length; i++){
            int sp = buildings[i][0];
            int ep = buildings[i][1];
            int height = buildings[i][2];
            list.add(new Pair(sp, -height));
            list.add(new Pair(ep , height));
        }
        Collections.sort(list);
        List<List<Integer>>ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int current_active_height  = 0;
        pq.add(0);

        for(int i= 0 ; i< list.size(); i++){
            int x = list.get(i).x;
            int height = list.get(i).height;

            if(height < 0){
                // staring point
                pq.add(-height);
            }
            else{
                pq.remove(height);
            }
            if(current_active_height != pq.peek()){
                List<Integer>temp = new ArrayList<>();
                temp.add(x);
                temp.add(pq.peek());
                ans.add(temp);
                current_active_height = pq.peek();

            }
        }
        return ans;


    }
    public static class Pair implements  Comparable<Pair>{
        int x;
        int height ;
        public Pair(int x, int height){
            this.x = x;
            this.height = height;
        }


        @Override
        public int compareTo(Pair o) {
            if( this.x != o.x){
                return (this.x - o.x);
            }
            else return (this.height - o.height);
        }
    }
}
