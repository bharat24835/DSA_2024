package Problem_Of_Day;

import java.util.Arrays;

public class Palindromic_SubString {
    public static void main(String[] args) {
        String  s = "bbbab";
        System.out.println(call(s));
    }
    public static int call(String s){
        StringBuilder ans = new StringBuilder();
        int count = 0 ;
        int maxi = 0;
        int maxj = 0;
        int n  = s.length();
        int[][]dp = new int[s.length()][s.length()];
        for(int[]b:dp){
            Arrays.fill(b,0);
        }

        // in this approach we will try to operate lenght wise
        for (int l = 1 ; l<=n; l++){
            for(int i = 0 ; i+l-1<n ; i++){
                int j = i+l-1;
                // for 1 Length
                if( i== j ){
                    dp[i][j] = 1;
                }else if(i+1 == j){ // for 2 Length
                    if(s.charAt(i) == s.charAt(j))  dp[i][j] = 1;

                }
                else{
                    // Any arbitary Length
                    if(s.charAt(i) == s.charAt(j) && (dp[i+1][j-1] ==1 || dp[i+1][j] == 1 || dp[i][j+1] ==1 )){
                        dp[i][j] =1;
                    }
                }
                if(dp[i][j] == 1) {
                    count++;
                    maxi = i;
                    maxj = j;
                }

            }
        }
        if(maxi+1< n )
        System.out.println(s.substring(maxi,maxj+1));
        else System.out.println(s.substring(maxi));
        return count;
    }

}
