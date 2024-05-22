package POD_GFG;

import java.util.Arrays;

public class Two_Repeated_Elements {
    public static void main(String[] args) {
        int[]a = {9,1,5,6,4,3,10,8,4,2,2,7};
        int[]b = call(a);
        System.out.println(Arrays.toString(b));
    }
    public static int[] call(int[]a ){

       int[]ans = new int[2];
       int count  = 0 ;


       for(int i = 0 ; i<a.length ; i++){
           int t = Math.abs(a[i])-1;

           if(a[t] < 0) {
               // means it is already visited
               if(count > 1) break;
               ans[count++] = Math.abs(a[i]);
           }
           a[t] =-a[t];
       }
       return ans;
    }
    public static void swap(int []a , int i)
    {
        int index = a[i]-1;
      //  System.out.println(" Swapping between Index: "+i+"  " + index);
        int temp = a[index];
        a[index]= a[i];
        a[i]= temp;
    }
}
