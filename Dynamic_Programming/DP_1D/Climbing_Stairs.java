package Dynamic_Programming.DP_1D;

import java.util.Arrays;

public class Climbing_Stairs {
    public static void main(String[] args) {
        int n = 2;
        int[]dp = new int[n+1];
        Arrays.fill(dp , -1);
       // System.out.println(call( 0, n , dp));
        //System.out.println(tabulation(n));
        System.out.println(tabulation1(n));
    }
    public static int call(int i , int n , int[]dp){
        if(i == n) return 1;
        if(i > n ) return 0;
        // at every step we have 2 choise s
        // either jump 1 or jump 2
        if(dp[i] != -1 )return dp[i];
        int take_1 = call(i+1 , n ,dp);
        int take_2 = call(i+2 , n,dp);
        return dp[i] =  take_2+ take_1;
    }
    public static int tabulation (int n){
        int[]dp = new int[n+2];
        // fill out base case
        dp[n] = 1;
        for(int i = n-1 ; i>=0 ; i--){
            int take_1 = dp[i+1];
            int take_2 = dp[i+2];
            dp[i] = take_2+ take_1;
        }
        return dp[0];
    }
    public static int tabulation1(int n){
        int next_1 = 1;
        int next_2 = 0;

        for(int i = n-1 ; i>=0 ; i--){
            int take_1 = next_1;
            int take_2 = next_2;

            int sum = take_1 + take_2;
            next_2  =next_1;
            next_1 = sum;
        }
        System.out.println("Next_1 " + next_1 );
        System.out.println("Next_2 " + next_2 );
        return next_1;
    }
}
