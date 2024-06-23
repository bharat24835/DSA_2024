package Binary_Search.Search_On_Answer;

import java.util.Arrays;

public class Magnetic_Force_Between_Two_Balls {
    public static void main(String[] args) {
        int[]a= {5,4,3,2,1,1000000000};
        int m = 2;
        System.out.println(call(a , m));
    }
    public static int call(int[]a , int m){
        Arrays.sort(a);
        int n = a.length;
        int minF  = 1;
        int maxF  = a[n-1] - a[0];

        int ans = 1;

        while( minF<= maxF){
            int mid = minF + (maxF - minF)/2;

            if(call1(mid , m , a )){
                ans = mid;
                minF = mid+1;
            }
            else{
                maxF = mid-1;
            }

        }
        return ans;
    }
    public static boolean call1(int force, int m , int []a){
        // how we need to check
        // wheather we can place m balls with min separtion of force

        int prev = a[0];

        int count =1;
        for(int i =1 ; i<a.length; i++){
            int alt_positino = a[i];
            int dis = alt_positino - prev;
            if(dis >=  force){
                prev = alt_positino;
                count++;
            }
            if(count == m) return true;
        }
        return false;
    }
}
