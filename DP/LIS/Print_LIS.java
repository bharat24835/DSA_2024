package DP.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Print_LIS {
    public static void main(String[] args) {
        int[]a = {5,4,11,1,16,18};
        System.out.println(call(a));
        System.out.println(call1(a));
    }
    public static int call(int[]a){

        int[]dp = new int[a.length];
        Arrays.fill(dp,1);


        //first of all we need to midify do
        int max = 1;
        for(int i =0  ; i<a.length; i++){
            for(int prev = 0 ; prev<=i-1; prev++){
                if(a[i] > a[prev] ){
                    dp[i] = Math.max(1+ dp[prev] , dp[i]);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

                       // PRINTING LIST
    public static List<Integer>call1(int[]a){
    List<Integer>ans = new ArrayList<>();

    int[]dp = new int[a.length];
    Arrays.fill(dp,1);
    int[]hash = new int[a.length];

    int max = 1;
    int lastIndex = 0;

    for(int i = 0 ; i<a.length; i++){
        hash[i] = i;
        for(int prev = 0 ; prev<=i-1 ; prev++){
            if(a[i] > a[prev] && (1+dp[prev]) > dp[i] ){
                dp[i] = 1 +dp[prev];
                hash[i] =prev;
            }
        }

        if(dp[i] > max){
            max = dp[i];
            lastIndex = i;
        }
    }


    // Now Printing Part Starts Now
        ans.add(a[lastIndex]);  // basic need
        while(hash[lastIndex] != lastIndex){
            lastIndex  = hash[lastIndex];
            ans.add(0 ,a[lastIndex]);
        }
        return ans;


    }
}
