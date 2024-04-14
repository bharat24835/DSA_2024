package Sliding_Window;

import java.util.HashMap;
import java.util.Map;

public class leetCode_992 {
    public static void main(String[] args) {
        int[]a = {1,2,1,2,3};
        int k = 2;
        int a1 = call(a , k);
        int a2 = call(a , k-1);
        System.out.println(a1- a2);
    }
    public static int call(int []a , int k){
        Map<Integer , Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;
        int count = 0;

        while( j < a.length){
            // taking a[j] element
            map.put(a[j] , map.getOrDefault(a[j] , 0)+1 );

            // shrinking
            while( i<=j && map.size() > k){
                map.put(a[i] , map.get(a[i])-1);
                if(map.get(a[i]) == 0)map.remove(a[i]);
                i++;

            }
            if(map.size() <= k){
                count+= (j-i+1);
            }
            j++;
        }
        return count;


    }
}
