package Array.Medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Insert_Interval {
    public static void main(String[] args) {
        int[][]interval = {{3,5} , {6,9} };
        int[]new_interval = {1,3};
        //System.out.println(Arrays.toString(interval));
        int[][]ans = call(interval , new_interval);
        for(int i = 0 ; i< ans.length; i++){
           System.out.println(Arrays.toString(ans[i]));
        }
    }

    public static int[][] call(int[][]interval , int[]new_interval){
        // first we need to find the position on which we are goint to plcae start(i) of new_interval


        List<List<Integer>> outer = new ArrayList<>();
        int find_start = new_interval[0] ;
        int find_end = new_interval[1];
        int i = 0;
        for(i = 0 ; i<interval.length ; i++){
            if(interval[i][0] > new_interval[0]){
                break;
            }
            if(interval[i][0] <= new_interval[0] && interval[i][1] >= new_interval[0]){
                find_start = interval[i][0];
                break;
            }
            else{
                List<Integer>inner = new ArrayList<>();
                inner.add(interval[i][0]);
                inner.add(interval[i][1]);
                outer.add(inner);
            }
        }

        while( i <interval.length ){
            if(interval[i][0] > new_interval[1]){
                break;
            }
            if(interval[i][0] <= new_interval[1] && interval[i][1] >= new_interval[1]){
                find_end = interval[i][1];
                i++;
                break;
            }
            i++;

        }

        // adding the remined item
        List<Integer>inner = new ArrayList<>();
        inner.add(find_start);
        inner.add(find_end);
        outer.add(inner);
        while(i < interval.length){
            List<Integer>temp  = new ArrayList<>();
            temp.add(interval[i][0]);
            temp.add(interval[i][1]);
            outer.add(temp);
            i++;
        }
        System.out.println("Printing");
        System.out.println(outer);




       int[][]ans  = new int[outer.size()][2];

       for( i = 0 ; i<outer.size(); i++){
           ans[i][0] = outer.get(i).get(0);
           ans[i][1] = outer.get(i).get(1);
       }

     return ans;
    }
}
