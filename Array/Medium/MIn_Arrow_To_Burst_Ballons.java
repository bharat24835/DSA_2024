package Array.Medium;

import java.util.Arrays;
import java.util.Comparator;

public class MIn_Arrow_To_Burst_Ballons {
    public static void main(String[] args) {
      // int[][]points = {{3,9} , {7,12} , {3,8} , {6,8} ,{9,10} ,{2,9} ,{0,9} ,{3,9},{0,6},{2,8}};
        int[][]points = {{9,12} , {1,10}, {4,11} , {8,12},{3,9},{6,9},{6,7}};
    //    [[3,9],[7,12],[3,8],[6,8],[9,10],[2,9],[0,9],[3,9],[0,6],[2,8]]
    //    [[9,12],[1,10],[4,11],[8,12],[3,9],[6,9],[6,7]]


      System.out.println(call(points));
    }
    public static int call(int[][]points){

   Arrays.sort(points, new Comparator<int[]>() {
       @Override
       public int compare(int[] o1, int[] o2) {
           if(o1[1] == o2[1])return Integer.compare(o1[0], o2[0]);
           return Integer.compare(o1[1] , o2[1]);
       }
   });

   int count = 1;
   int i =1;
   int n = points.length;
   boolean[]burst = new boolean[n];
   int prev_end = 0;

   while(i < n){
       if(points[prev_end][1] >= points[i][0]){

       }
       else{
           count++;
           prev_end = i;
       }
       i++;
   }
   return count==0? 1:count;





    }

}
