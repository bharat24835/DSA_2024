package Prefix_Sum;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Max_SunArray_No_Larget_Than_K {
    public static void main(String[] args) {
        int[]a = {5,-2,6,3,5};
        int k = 15;
        System.out.println(call(k , a));
    }
    public static int call(int k , int[]a){
      int []prefix = new int[a.length];
      //prefix[0]  =a[0];
      for(int i = 0 ; i<a.length; i++){
        prefix[i] = a[i] + (i>0 ? prefix[i-1]: 0);
      }
      int sum  = 0 ;
      int max = 0;
      TreeSet<Integer> set = new TreeSet<>();
      set.add(0);
      for(int i = 0 ; i<a.length; i++){
          sum+=a[i];
          Integer first = set.ceiling(sum  -k);
          if(first != null){
                 max = Math.max(max , sum - first);
          }

          set.add(sum);


      }
      return max;
    }
}
