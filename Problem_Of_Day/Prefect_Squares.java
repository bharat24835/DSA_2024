package Problem_Of_Day;

import java.util.Arrays;

public class Prefect_Squares {
    public static void main(String[] args) {
        int x = 12;
        int n = (int)Math.sqrt(x);
        int[][]dp =new int[n+1][x+1];
        for(int[]b:dp){
            Arrays.fill(b, -1);
        }
        System.out.println(call(n, x,dp));
    }
    public static int call(int i  , int target, int[][]dp){
        if( i == 0 || target < 0)return (int)1e5;
        if(target == 0)return 0 ;
        if(dp[i][target]!= -1) return -1;
        int count = Integer.MAX_VALUE;

        for(int j = i ; j>0 ; j--){
            int ans  =1 +  call(j , target  -j*j,dp);
            count = Math.min(ans, count);
        }
        return dp[i][target] =  count;


    }
}
