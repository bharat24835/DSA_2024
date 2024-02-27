package DP.LIS;

import java.util.Arrays;

public class Longest_Increasing_Subsequence {
    public static void main(String[] args) {
        int[]a = {10,9,2,5,3,7,101,18};
        int[][]dp = new int[a.length][a.length+1];
        for(int []b:dp){
            Arrays.fill(b, -1);
        }
        System.out.println(call(0,-1,a,dp));
        System.out.println(call2(a));
    }
    public static int call(int i , int previ,int[]a,int[][]dp){
        if( i == a.length)return 0;
        if(dp[i][previ+1] != -1 )return dp[i][previ+1];
        // takeit
        int take = 0;
        if(previ == -1 || a[i] > a[previ])
            take = 1 + call(i+1, i ,a,dp);
        int ignore = 0 +call(i+1,previ,a,dp);
        return dp[i][previ+1] =  Math.max(take,ignore);
    }
                // TABULATION
    public static int call2(int []a){
        int n = a.length;
        int[][]dp = new int[a.length+1][a.length+1];
        // base case already filled

        for(int i =n-1 ; i>=0 ; i-- ){
            for(int prev  = i-1; prev>=-1 ; prev--){
                int ignore = 0 + dp[i+1][prev+1];
                int take = 0;
                if( prev == -1 || a[i] > a[prev]){
                    take = 1 + dp[i+1][i+1];
                }
                dp[i][prev+1] = Math.max(take,ignore);
            }
        }
        return dp[0][0];

    }
}
