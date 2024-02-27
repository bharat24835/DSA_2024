package Sliding_Window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Fuit_Into_Basket {
    public static void main(String[] args) {
        int[]a =  {1,2,3,2,2};
        System.out.println(call(a));

    }
    public static int call(int[]a){

        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int i = 0;
        int j = 0;

        while( j< a.length){
            int item = a[j];
            map.put(item  , map.getOrDefault(item , 0) +1);


            // If
           while(map.size() == 3){
               int first = a[i];
               if(map.get(first) == 1 ) map.remove(first);
               else map.put(first, map.get(first)-1);
               i++;
           }


            ans  = Math.max(ans , j-i+1);
           j++;
        }
        return ans;
    }
}
