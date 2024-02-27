package Sliding_Window;

import java.util.HashSet;
import java.util.Set;

public class Maximum_Erasure_Value {
    public static void main(String[] args) {
        int[]a = {5,2,1,2,5,2,1,2,5};
        //int[]a ={4,2,4,5,6};
        System.out.println(call(a));
    }
    public static int call(int[]a){
        int sum =0;
        int max = 0;

        Set<Integer> set = new HashSet<>();

        int i = 0;
        int j =0;

        while( j < a.length){
            int item  = a[j];

            if(set.contains(item)){

                while(set.contains(item)){
                    int first = a[i];
                    set.remove(first);
                    i++;
                    sum-=first;
                }
                set.add(item);
                sum+=item;

            }
            else{
                set.add(item);
                sum+=item;
            }

            max = Math.max(sum , max);
            j++;

        }
        return max;

    }
}
