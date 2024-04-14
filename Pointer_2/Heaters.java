package Pointer_2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Heaters {
    public static void main(String[] args) {
        int[]houses = {1,5};
        int[]heaters = {10};
        System.out.println(call(houses, heaters));
    }
    public static int call(int[]houses, int[]heaters){
        Set<Integer> house_covered = new HashSet<>();
        Set<Integer>house_temp = new HashSet<>();
        int min_house = Integer.MAX_VALUE;
        int max_house = 0;


        Queue<Pair> q = new LinkedList<>();
        for(int i =0 ; i<houses.length; i++){
            house_temp.add(houses[i]);
            min_house = Math.min(min_house,houses[i]);
            max_house = Math.max(max_house,houses[i]);
        }

        for(int i = 0 ; i<heaters.length; i++){
            int temp = heaters[i];
            q.offer(new Pair(temp,0));
            house_covered.add(temp);

            if(house_temp.contains(temp))
                house_temp.remove(temp);
        }
        int level = 0;

        while(!q.isEmpty() && !house_temp.isEmpty() ){
            int size = q.size();

            for(int x = 0 ; x<size; x++){
                Pair temp = q.poll();
                int house_no  = temp.house;
                int dis = temp.dis;

                // movifn left
                if(house_no - 1 >= min_house && !house_covered.contains(house_no-1)){
                    q.offer(new Pair(house_no-1, dis+1));
                    house_covered.add(house_no-1);

                    if(house_temp.contains(house_no-1)){
                        house_temp.remove(house_no-1);
                    }
                }
                // moving right
                if(house_no+1 <=max_house && !house_covered.contains(house_no+1)){
                    q.offer(new Pair(house_no+1, dis+1));
                    house_covered.add(house_no+1);

                    if(house_temp.contains(house_no+1)){
                        house_temp.remove(house_no+1);
                    }
                }
            }
            level++;

        }
        return level;
    }
    public static class Pair{
        int house;
        int dis;
        Pair(int a , int b){
            this.house = a;
            this.dis = b;
        }
    }
}
