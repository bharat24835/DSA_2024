package DP.String;

public class Longest_Common_Substring {
    public static void main(String[] args) {
        String s1 = "abcjklp";
        String s2 = "acjkp";
        System.out.println("Recurssion  : " + call(0,0,s1 , s2));
        System.out.println("Tabulation : " + call2(s1 , s2));

    }

    public  static int call( int i , int j ,String s1 , String s2){
         if( i== s1.length() || j == s2.length()) return 0;

         // take
        int take = 0;
        if(s1.charAt(i) == s2.charAt(j)){
            take = 1 + call(i+1 , j+1 , s1,s2);
        }
        int ig1 = call(i+1 , j ,s1,s2);
        int ig2 = call(i , j+1 ,s1,s2);

        return Math.max(take ,Math.max(ig1 , ig2));


    }
    public  static  int call2(String s1, String s2){
        int[][]dp = new int[s1.length()+1][s2.length()+1];

        // filling the base case
        for(int i = 0 ; i<=s1.length() ; i++) dp[i][0] = 0;
        for(int i = 0 ; i<=s2.length() ; i++) dp[0][1] = 0;

        int[]max = new int[2];


        int n = s1.length();
        int m = s2.length();
        int ans = 0;
        for(int i = n-1 ; i>=0 ; i-- ){
            for(int j = m-1 ; j>=0 ; j--){

                if(s1.charAt(i) == s2.charAt(j))
                {
                    int val =  1 + dp[i+1][j+1];
                    dp[i][j] = val;
                    if(ans  < dp[i][j]){
                        max[0] = i;
                        max[1] = j;
                    }
                    ans = Math.max(ans , dp[i][j]);
                }
                else{
                    dp[i][j] = 0;
                }

            }
        }
        System.out.println("Max[0] : "  + max[0] + " and Max[1] : " + max[1]);
        int i  = max[0];
        int j = max[1];
        // printing of Longest Common Substring
        String s  = "";

        while(i < n && j < m){
            if(dp[i][j] == 0) break;
            s = s + s1.charAt(i);
            i++;
            j++;
        }
        System.out.println("Longest Common String is    " + s);

        return ans;
    }
}
