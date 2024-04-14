package Dynamic_Programming.DP_1D;

import java.util.Arrays;

public class Frog_Jump {
    public static void main(String[] args) {
        int[]a ={7 ,5, 5, 8, 4 ,9 ,1 ,1 ,10};
        int[]dp = new int[a.length];
        Arrays.fill(dp , -1);
        System.out.println(call(0 , a , dp));
        System.out.println(call1(a));
        System.out.println(call2(a));
    }
    public static int call(int i , int[]a , int[]dp){
        if(i == a.length-1 ) return 0;
        if(i >= a.length) return Integer.MAX_VALUE;

        if(dp[i] != -1 )return dp[i];
        // take one step
        int take_1  = Integer.MAX_VALUE;
        if(i+1 < a.length)
            take_1 = Math.abs(a[i+1] - a[i] ) + call(i+1 , a,dp);
        int take_2 = Integer.MAX_VALUE;
        if(i+2 < a.length)
            take_2  = Math.abs(a[i+2]  -a[i]) + call(i+2  , a,dp);

        return dp[i] = Math.min(take_1 , take_2);
    }
    public static int call1(int []a){
        int n = a.length;
        int[]dp = new int[n+1];

        // fill base case
        dp[n]  = 0;

        for(int i = n-1 ; i>=0 ; i--){

            int take_1 = 0;
            if(i+1 < n)
                take_1 = Math.abs(a[i+1] - a[i]) + dp[i+1];
            int take_2 = 0 ;
            if(i+2 < n)
                take_2 = Math.abs(a[i+2]  - a[i])  + dp[i+2];

            dp[i] = Math.min(take_1 , take_2);
        }
        return dp[0];
    }
    public static int call2(int []a){
        int n = a.length;
        int next_1 = 0;
        int next_2 = Integer.MAX_VALUE;

        for(int i = n-2 ; i>=0 ; i--){
            int take_1 = Integer.MAX_VALUE;
            if(i+1 < n)
                take_1 = Math.abs(a[i+1] - a[i]) + next_1;
            int take_2 = Integer.MAX_VALUE;
            if(i+2 < n)
                take_2 = Math.abs(a[i+2] - a[i]) + next_2;

            next_2 =  next_1;
            next_1 = Math.min(take_1 , take_2);
        }
        System.out.println(next_1);
        System.out.println(next_2);
        return next_1;
    }
}
