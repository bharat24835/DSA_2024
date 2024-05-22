package Contest_LeetCode.April_27;

import java.util.HashMap;
import java.util.Map;

public class Question2 {
    public static void main(String[] args) {
        int[][]a ={{1,0,1} ,{1,0,0} , {1,0,0}};
        System.out.println(call(a));
    }
    public static int call(int[][]a){
        Map<Integer, Integer> row_map = new HashMap<>();
        Map<Integer, Integer> col_map = new HashMap<>();

        for(int i = 0 ; i<a.length ; i++){
            for(int j = 0 ; j<a[i].length ; j++){
                if(!row_map.containsKey(i))row_map.put(i, 0);
                if(!col_map.containsKey(j))col_map.put(j, 0);
               if(a[i][j] == 1){
                   // filling in row
                   row_map.put(i , row_map.getOrDefault(i , 0)+1);

                   // filling the col
                   col_map.put(j , col_map.getOrDefault( j , 0)+1);
               }
            }
        }
        int ans = 0;
        for(int i = 0 ; i<a.length ; i++){
            for(int j = 0 ; j<a[i].length ; j++){
                if(a[i][j] == 1){

                    int rowSum = row_map.get(i)-1;
                    int colSum = col_map.get(j)-1;
                    if(rowSum> 0 && colSum > 0){
                        ans+= rowSum*colSum;
                    }

                }
            }
        }
        return ans;
    }
}
