package Array.Medium;

import java.util.Arrays;

public class Count_Alternate_SubArrays {
    public static void main(String[] args) {
        int[]a = {0,1,1,1};
        int[]dp = new int[a.length];
        Arrays.fill(dp, -1);
        System.out.println(call(a));

    }
    public static int call( int []a ){
       int i = 0;
       int j = 0;
       int count = 0;

       while(j < a.length){
           int temp = 1;

           while(j>0 && i<=j && a[j] == a[j-1]){
               i++;
           }

           count+= i > j ? 1 : (j-i+1);
           j++;

       }
       return count;
    }
}
