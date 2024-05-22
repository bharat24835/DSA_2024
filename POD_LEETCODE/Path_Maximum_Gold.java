package POD_LEETCODE;

import java.util.LinkedList;
import java.util.Queue;

public class Path_Maximum_Gold {
    public static void main(String[] args) {
        int[][] a = {{0,6,0} , {5,8,7} , {0,9,0}};
        System.out.println(call(a));
    }
    public static int call(int[][]a){
        int ans  = 0;
        for(int i = 0 ; i<a.length; i++){
            for (int j = 0 ;  j<a[i].length; j++){

                if(a[i][j] != 0){
                    int[][]visited = new int[a.length][a[0].length];
                    int sum = call1( i , j , a , visited);
                    ans = Math.max(ans , sum);
                }
            }
        }
        return ans;
    }
    public static int call1(int i , int j , int[][]a , int[][]visited){

        int sum = 0;
        sum+=a[i][j];
        visited[i][j] = 1;
        int altSum = 0;

        // up
        if(i-1 >=0 && a[i-1][j] != 0 && visited[i-1][j] == 0){
            altSum = Math.max(altSum , call1(i-1 , j , a, visited));
        }
        // down
        if(i+1<a.length && a[i+1][j] != 0 && visited[i+1][j] == 0){
            altSum = Math.max(altSum , call1(i+1 , j , a, visited));
        }
        // left
        if(j-1 >=0 && a[i][j-1] != 0 && visited[i][j-1] == 0){
            altSum = Math.max(altSum , call1(i , j-1 , a, visited));
        }
        // right
        if(j+1 < a[0].length && a[i][j+1] != 0 && visited[i][j+1] == 0){
            altSum = Math.max(altSum , call1(i , j+1 , a, visited));
        }

        return sum+altSum;
    }
}
 class Pair{
    int i ;
    int j ;
    Pair(int a, int b){
        this.i = a;
        this.j = b;
    }
}
