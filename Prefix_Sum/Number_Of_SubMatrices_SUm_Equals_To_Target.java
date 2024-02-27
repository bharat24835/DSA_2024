package Prefix_Sum;

import java.util.HashMap;
import java.util.Map;

public class Number_Of_SubMatrices_SUm_Equals_To_Target {
    public static void main(String[] args) {
        int[][]a  = {{0,1,0},{1,1,1},{0,1,0}};
        int k = 2;
        System.out.println(call(a,k));
    }
    public static int call(int[][]a, int k){
        // first of all we need to form row wise prefix sum
        int m = a.length;
        int n = a[0].length;
        for(int i =0 ; i<m ; i++){
            for(int j = 1; j<n ; j++){
                a[i][j]+=a[i][j-1];
            }
        }

        // now we need to think out of the box
        int count = 0 ;

        // let our staring index is sc

        for(int sc = 0 ; sc<n ;sc++ ){

            for(int j = sc ; j<n ; j++){

                int sum = 0 ;
                Map<Integer, Integer>map = new HashMap<>();
                map.put(0,1);
                for(int i = 0  ; i<m ; i++){
                    sum+=a[i][j] - (sc>0 ? a[i][sc-1]:0);
                    int target = sum - k;
                    if(map.containsKey(target)){
                        count+=map.get(target);
                    }
                    map.put(sum , map.getOrDefault(sum,0)+1);
                }
            }

        }
        return count;
    }
}
