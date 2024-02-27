package Problem_Of_Day;

import java.util.Arrays;

public class Partition_Array_For_Maximum_Array {
   // public static int k;
    public static void main(String[] args) {
        int[]a ={1,15,7,9,2,5,10};
       int k = 3;
       int[]dp = new int[a.length+1];
        Arrays.fill(dp, -1);
        System.out.println(call(0, k , a,dp));
    }
    public static int call(int indx ,int  k , int[]a,int[]dp){
      if( indx == a.length)
          return 0;
      if(dp[indx] != -1)return dp[indx];
      int max = 0;
      int result = 0;
      for(int i = indx; i<Math.min(indx+k , a.length); i++){

          max =Math.max(max,a[i]);
          int ans = (i - indx+1)*max + call(i+1 , k , a ,dp);
          result = Math.max(result,ans);
      }
      return dp[indx] = result;


    }
}
