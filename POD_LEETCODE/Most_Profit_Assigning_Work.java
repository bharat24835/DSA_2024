package POD_LEETCODE;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Most_Profit_Assigning_Work {
    public static void main(String[] args) {
        int[]difficulty = {2,4,6,8,10};
        int[]profit = {10,20,30,40,50};
        int[]worker = {4,5,6,7};


        TreeMap<Integer, Integer> diff_map = new TreeMap();
        for(int i  = 0 ;i<difficulty.length; i++){
            diff_map.put(difficulty[i] , i);
        }

        int ans = 0;
        for(int i = 0  ; i<worker.length ; i++){
            Map.Entry<Integer , Integer> pair = diff_map.floorEntry(worker[i]);

            ans+=profit[diff_map.get(pair.getKey())];
        }

        System.out.println(ans);

    }
}
