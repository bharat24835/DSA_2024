package DP.String;

import java.util.Arrays;

public class Longest_Common_SubSequence {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "bdgek";
        System.out.println("Answer by Memoization " + call(s1, s2));
        System.out.println("Answer by Tabulation Step  "  + call2(s1, s2));
    }
    public static int call(String s1 , String s2){
        int[][]dp = new int[s1.length()][s2.length()];
        for(int []b :dp) Arrays.fill(b , -1);
        return call1( 0,0, s1,s2 , dp);

    }
    public static int call1(int i  , int j  ,String s1 , String s2 ,int[][]dp){
        if( i== s1.length() || j == s2.length()) return 0;

        if(dp[i][j]!= -1) return dp[i][j];
        // match
        int take = 0;
        int ignore = 0;
        if(s1.charAt(i) == s2.charAt(j)){
            take  = 1 + call1(i+1, j+1 , s1,s2 , dp);
        }
        // not match
        else{
            ignore = Math.max(call1(i+1 , j, s1, s2,dp) , call1(i , j+1, s1,s2 , dp));
        }


        return dp[i][j] =  Math.max(take , ignore);
    }
    // Tabulation
    public  static  int call2(String s1, String s2){
       int[][]dp = new int[s1.length()+1][s2.length()+1];

        // filling the base case
        for(int i = 0 ; i<=s1.length() ; i++) dp[i][0] = 0;
        for(int i = 0 ; i<=s2.length() ; i++) dp[0][1] = 0;

        int n = s1.length();
        int m = s2.length();

        for(int i = n-1 ; i>=0 ; i-- ){
            for(int j = m-1 ; j>=0 ; j--){
                int take = 0 ;
                int ignore = 0;
                if(s1.charAt(i) == s2.charAt(j)){
                    take  = 1 + dp[i+1][j+1];
                }
                else{
                    ignore = Math.max(dp[i+1][j] , dp[i][j+1]);
                }
                dp[i][j] = Math.max(take , ignore);
            }
        }
        int i  = 0;
        int j = 0;
        String ans  = "";

        while(i < n && j < m){
             if(s1.charAt(i) == s2.charAt(j)){
                 ans = ans+s1.charAt(i);
                 i++;
                 j++;
             }
             else if(i<n && j<m && dp[i][j+1] > dp[i+1][j]){
                 j++;
             }
             else if(i < n && j < m && dp[i][j+1] < dp[i+1][j]){
                 i++;
             }
        }
        System.out.println("Longest Common SubSequence is    " + ans);

        return dp[0][0];
    }

}
