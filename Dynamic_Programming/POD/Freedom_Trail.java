package Dynamic_Programming.POD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Freedom_Trail {
    public static void main(String[] args) {
        String a  ="godding";
        String key = "gd";
        System.out.println(call(a , key));
    }
    public static int call(String a , String key){
        int[][]dp = new int[a.length()][key.length()];

        for(int[]b :dp){
            Arrays.fill(b ,-1);
        }
        return call1( 0 ,0 , a, key , dp);
    }
    public static int call1( int ring_index , int index , String a , String key , int[][]dp){
        if( index == key.length())return 0;

        // search for jth index
        if(dp[ring_index][index] != -1) return dp[ring_index][index];
        int resutl = Integer.MAX_VALUE;
        for(int i = 0 ; i<a.length() ; i++){
            if(a.charAt(i) == key.charAt(index)){
                int step = 1 +  call2( ring_index ,i , a.length() );
                int total_step = step + call1( i ,index+1  , a, key,dp);

                resutl = Math.min(total_step , resutl);
            }

        }
        return dp[ring_index][index] =  resutl;

    }


    public static int call2 (int ring_Index ,int index, int n ){
        int clockwise = Math.abs(index - ring_Index);
        int anti_clockwise = n - clockwise;
        return Math.min(clockwise , anti_clockwise);
    }

}
