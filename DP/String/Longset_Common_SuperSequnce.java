package DP.String;

public class Longset_Common_SuperSequnce {
    public static void main(String[] args) {
        String s1= "brute";
        String s2= "groot";
        System.out.println("HELLO");
        int temp = call2(s1 , s2);
        System.out.println("Length of  LCS is " + temp);
        int ans = s1.length() + s2.length() -temp ;
        System.out.println("SuperSequnce is of length : " + ans);
    }
    public  static  int call2(String s1, String s2){
        int[][]dp = new int[s1.length()+1][s2.length()+1];

        // filling the base case
        for(int i = 0 ; i<=s1.length() ; i++) dp[i][s2.length()] = 0;
        for(int i = 0 ; i<=s2.length() ; i++) dp[s1.length()][i] = 0;

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
        String ans = "";
        // printing of Longest Common
        System.out.println("Prinitng teh DP Table");
        for (int p = 0 ; p < dp.length; p++ ){
            for(int q = 0  ; q<dp[p].length ; q++){
                System.out.print(dp[p][q] + " ");
            }
            System.out.println("");
        }

        while(i < n && j < m){
            if(s1.charAt(i) == s2.charAt(j)){
                ans = ans + s1.charAt(i);
                i++;
                j++;
            }
            else if(i<n && j<m && dp[i][j+1] > dp[i+1][j]){
                ans = ans + s2.charAt(j);
                j++;
            }
            else if(i < n && j < m && dp[i][j+1] <= dp[i+1][j]){
                ans = ans + s1.charAt(i);
                i++;
            }
        }
        while(i < n){
            ans = ans + s1.charAt(i++);
        }
        while(j < m){
            ans = ans + s2.charAt(j++);
        }
        System.out.println("Longest Common SubSequence is    " + ans);

        return dp[0][0];
    }
}
