package DP.Basics;

import java.util.Arrays;

public class Max_Alternating_SubSequence_Sum {
    public static void main(String[] args) {
        int[]a ={5,6,7,8};
        int[][]dp = new int[a.length+1][2];
        for(int[]b:dp){
            Arrays.fill(b,-1);
        }
        System.out.println(call3(a));
        System.out.println(call2(a));
        System.out.println(call1(a.length-1, 0,a,dp));
        System.out.println(call(a.length-1 , 0,a));
    }
    public static int call(int i ,int flag, int[]a ){
        if(i < 0)return 0;

        // take it Or Ignore it
        int take = call(i-1, (flag+1)%2, a) + (flag== 0  ? a[i] : -1*a[i]);
        int ignore = call(i-1, flag, a);
        return Math.max(take,ignore);
    }

    public static int call1(int i , int flag , int[]a, int[][]dp){
        if(i < 0)return 0;
        if(dp[i][flag]!=-1)return dp[i][flag];
        // take it Or Ignore it
        int take = call(i-1, (flag+1)%2, a) + (flag== 0  ? a[i] : -1*a[i]);
        int ignore = call(i-1, flag, a);
        return dp[i][flag] = Math.max(take,ignore);
    }
    public static int call2(int[]a){
        int[][]dp = new int[a.length+1][2];

        // base case already filled
        for(int i =0 ; i<a.length; i++){
            for(int flag = 0 ; flag<=1 ; flag++){

                int takeit = (flag==0 ? a[i]:-1*a[i]) + dp[i-1+1][(flag+1)%2];
                int ignore = dp[i-1+1][flag];
                dp[i+1][flag] = Math.max(takeit,ignore);
            }
        }
        return dp[a.length][0];
    }
    public static int call3(int[]a){
        int[]prev = new int[2];

        for(int i =0 ; i<a.length;i++ ){
            int[]curr = new int[2];
            for(int flag = 0  ; flag<=1  ; flag++){
                int takeit = (flag==0 ? a[i]:-1*a[i]) + prev[(flag+1)%2];
                int ignore = prev[flag];
                curr[flag] = Math.max(takeit,ignore);
            }
            prev = curr;
        }
        return prev[0];
    }

}
