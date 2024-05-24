package DP.LIS;

import java.net.CacheRequest;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class The_Number_of_Beautiful_Subsets_2597 {
    public static void main(String[] args) {
        int[]a = {2,4,6};
        int k = 2;
        System.out.println(call(a , k));
    }
    public static int call(int[]a, int k){
        int n = a.length;
        int[]dp = new int[n];
        Arrays.fill(dp ,-1);
        Set<Integer> set = new HashSet<>();
        return call1( 0 ,k,  a, dp ,set);
    }
    public static int call1(int i ,int  k, int[]a , int[]dp , Set<Integer>set){
        if( i == a.length) return 0;

        // take it and ignore it
        if(dp[i]!= -1) return dp[i];
        int take = 0;
        int ignore  =0;

        // if we are taking particular index element , then Set shouls not contain the element (a[i]+k , a[i]-k)
        if(!set.contains(a[i]+k) && !set.contains(a[i]-k)){
            set.add(a[i]);
            take = 1 + call1(i+1 , k , a, dp , set);
            set.remove(a[i]);
        }

        ignore = call1(i+1 , k , a ,dp ,set);

        return dp[i]=  take+ ignore;
    }
}
