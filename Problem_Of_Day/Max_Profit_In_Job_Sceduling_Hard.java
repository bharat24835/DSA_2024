package Problem_Of_Day;

import java.util.Arrays;

public class Max_Profit_In_Job_Sceduling_Hard {
    public static int n  ;
    public static void main(String[] args) {
        int[]s = {6,15,7,11,1,3,16,2};
        int[]e = {19,18,19,16,10,8,19,8};
        int[]p = {2,9,1,19,5,7,3,19};
        n  = s.length;
           int[]dp = new int[n];
           sort(s,e,p);
        Arrays.fill(dp,-1);
        System.out.println(call( 0 , s,e,p,dp));
    }

    public static void sort(int[]s, int[]e, int[]p){

            int i, j;
            boolean swapped;
            for (i = 0; i < n - 1; i++) {
                swapped = false;
                for (j = 0; j < n - i - 1; j++) {
                    if (s[j] > s[j + 1]) {

                        // Swap Start
                        int temp1 = s[j];
                        s[j] = s[j + 1];
                        s[j + 1] = temp1;

                        //swap end
                        int temp2 = e[j];
                        e[j] = e[j + 1];
                        e[j + 1] = temp2;

                        // swap profit
                        int temp3 = p[j];
                        p[j] = p[j + 1];
                        p[j + 1] = temp3;

                        swapped = true;
                    }
                }

                // If no two elements were
                // swapped by inner loop, then break
                if (swapped == false)
                    break;

        }
    }
    public static int call(int i , int[]s , int[]e , int[]p, int[]dp){
        if(i >= n){
            return 0;
        }

        if(dp[i] != -1) return dp[i];

        // take it
      //  int tak_it = 0;
        int end = e[i];
        int max = Integer.MIN_VALUE;

        // get next index
        int next =  bs(i+1,end, s );
        int take_it = p[i] + call(next,s,e,p,dp);

        // ignore it
        int ignore_it = call(i+1, s,e,p,dp);
        return dp[i] = Math.max(take_it,ignore_it);
    }
    public static int bs(int j,int taget , int[]s ){

        // we need to find fisrt index whose
        int left = j ;
        int right = n-1;
        int ans = n+1;

        while(left <= right ){
            int mid = left + (right - left)/2;
            if(s[mid] >= taget){
                ans = mid;
                right  = mid-1;
            }
            else{
                left = mid + 1;
            }
        }
        return ans;

    }
}
