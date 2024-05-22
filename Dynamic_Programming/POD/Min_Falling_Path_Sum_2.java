package Dynamic_Programming.POD;

import java.util.Arrays;

public class Min_Falling_Path_Sum_2 {
    public static void main(String[] args) {
        int[][]a ={{1,2,3} , {4,5,6} , {7,8,9}};

        int[][]dp= new int[a.length][a[0].length+1];
        for(int[]b :dp){
            Arrays.fill(b ,-(int)1e9);
        }
        System.out.println(call( 0 , -1 , a, dp));

    }
    public static int call(int i , int j , int[][]a , int[][]dp){


        // for particular row ,  we need to iterate all the columsne except jth column ,
        if( i== a.length ) return 0;
        if(dp[i][j+1] != -(int)1e9) return dp[i][j+1];

        int ans = Integer.MAX_VALUE;

        for(int x = 0 ; x< a[i].length ; x++){
            int temp = Integer.MAX_VALUE;
            if(x !=  j){
                 temp = a[i][x] + call(i+1 , x , a, dp);

            }
            ans = Math.min(ans ,temp );
        }
        return dp[i][j+1] = ans;
    }
    public static int call1(int[][]a){

        int[][]dp = new int[a.length+1][a[0].length+1];
        // filling base cases for

        for(int j = 0 ; j<dp[0].length ;j++  ){
            dp[a.length][j] = 0;
        }

       return 0;
    }
}
