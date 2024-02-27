package DP.LIS;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Largest_Divisle_Subset {
    public static void main(String[] args) {
        int[]a = {5,9,18,54,108,540,90,180,360,720};
        Arrays.sort(a);
        System.out.println(call(a));
    }
    public static List<Integer> call(int[]a){
        int n = a.length;
        int[]dp = new int[n];
        Arrays.fill(dp ,1);
        int[]hash = new int[n];

        int max =1;
        int lasti = 0;

        for(int i = 0 ; i<a.length; i++){
            hash[i] = i;
            for(int prev = 0 ;prev<=i-1 ; prev++ ){

                if(a[i] % a[prev] == 0){
                    if(1 + dp[prev] > dp[i]){
                        dp[i] =  1 + dp[prev];
                        hash[i] = prev;
                    }
                }

                if(dp[i] > max){
                    max =  dp[i];
                    lasti = i;
                }
            }
        }

        List<Integer>ans = new ArrayList<>();
        ans.add(a[lasti]);
        while(hash[lasti] != lasti){
            lasti  = hash[lasti];
            ans.add(0 ,a[lasti]);
        }
        return ans;
    }
}
