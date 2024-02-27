package Problem_Of_Day;

import java.util.Arrays;

public class Divide_Array_Into_Arrays_With_Max_Difference {
    public static void main(String[] args) {
        int[]a= {15,13,12,13,12,14,12,2,3,13,12,14,14,13,5,12,12,2,13,2,2};
        int k = 2;
        int[][] temp = call(a,k);
        for(int i =0  ;i<temp.length; i++){
            System.out.println(Arrays.toString(temp[i]));
        }
    }
    public static int[][] call(int[] a, int k) {
        int m = a.length/3;
        int[][]ans = new int[m][3];
      //  int[][]temp = new int[m][3];

        Arrays.sort(a);
        int prev = -1;
        for(int i = 0 ; i<a.length ; i++){
            if(prev == -1){
                prev= a[i];
                ans[i/3][i%3] = a[i];
            }
            else if (prev!= a[i] && Math.abs(prev - a[i]) <= k ){
                prev = a[i];
                ans[i/3][i%3] = a[i];
            }
            else{
                return new int[0][0];
            }
            if(i%3 == 2){
                prev  = -1;
            }


        }
        return ans;


    }
}
