package DP.POD;

import java.util.Arrays;

public class Maximum_Score_Words_Formed_by_Letters_1255 {
    public static void main(String[] args) {
        String[]words = {"dog","cat","dad","good"};
        char[]letters = {'a','a','c','d','d','d','g','o','o'};
        int[]score = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};

        System.out.println(call(words , letters , score));
    }
    public static int call(String[]words, char[]letters , int[]score){
        // first of all we need to convert this letters into freq array
        int[]freq = new int[26];
        makeFreqArray(freq , letters);
        int[]dp = new int[words.length+1];
        Arrays.fill(dp , -1);


        return  call1( 0 , words , score , freq,dp);
    }
    public static int call1(int i , String[]words , int[]score , int[]freq  , int[]dp){
        if(i == words.length) return 0;

        // take it and ignore
        // take it have some condition (there should be available proper letters from freq array)
        // and we need to make another score function to calculate score function( string s , int[]score)
        if(dp[i] != -1) return dp[i];
        int take = 0;
        int ignore = 0;
        if(check(words[i] , freq)){
            makeChangesFreq(words[i] , freq);
            take = calculate_score(words[i] , score) + call1(i+1 , words  , score , freq , dp);
            revertChangesFreq(words[i], freq);
        }
        ignore  = call1(i+1 , words , score, freq ,dp);

        return Math.max(take , ignore);
    }

    public static int calculate_score(String s , int[]score ){
        int ans= 0;

        for(int i = 0 ; i<s.length() ; i++ ){
            int index = s.charAt(i)-'a';
            ans+=score[index];
        }
        return ans;
    }

    public static  void  makeChangesFreq(String s, int[]freq){
        for(int i = 0 ;i<s.length(); i++){
            int index = s.charAt(i) - 'a';
            freq[index]--;
        }
    }
    public static  void  revertChangesFreq(String s, int[]freq){
        for(int i = 0 ;i<s.length(); i++){
            int index = s.charAt(i) - 'a';
            freq[index]++;
        }
    }
    public static boolean check(String s, int[]freq){
        int[]temp = new int[26];
        for(int i = 0 ; i<s.length() ; i++){
            char character = s.charAt(i);
            int index = character - 'a';
            temp[index]++;
        }
        for(int i = 0 ; i<26 ; i++){
            if(temp[i] > freq[i]) return false;
        }
        return true;
    }
    public static void makeFreqArray(int[]freq , char[]letters){
        for(int i = 0 ; i<letters.length ; i++){
            int index = letters[i]-'a';
            freq[index]++;
        }
    }
}
