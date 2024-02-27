package Sliding_Window;

import java.util.HashSet;
import java.util.Set;

public class Min_Consecutive_Cards_To_Pick_Up {
    public static void main(String[] args) {
        int[]a ={2,1,2,1,1};

        System.out.println(call(a));
    }
    public static int call(int[]a){
        int min = Integer.MAX_VALUE;
        int n = a.length;
        Set<Integer> set = new HashSet<>();

        int i = 0 ;
        int j = 0 ;

        while(  j <a.length){
            int item = a[j];
            if(set.contains(item)){
              //  set.add(item);

                // shrink the window size upto
                while(set.contains(item)){
                    min = Math.min(min , j-i+1);
                    int first = a[i];
                    set.remove(first);
                    i++;
                }
                set.add(item);

            }
            else{
                set.add(item);
            }
            j++;

        }
        return min== Integer.MAX_VALUE ? -1:min;

    }
}
