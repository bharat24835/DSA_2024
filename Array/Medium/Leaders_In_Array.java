package Array.Medium;

import java.util.ArrayList;
import java.util.List;

public class Leaders_In_Array {
    public static void main(String[] args) {
        int[]a = {10, 22, 12, 3, 0, 6};
        System.out.println(call(a));
    }
    public static List<Integer> call(int[]a){
        List<Integer>list = new ArrayList<>();

        int max = Integer.MIN_VALUE;

        for(int i = a.length-1; i>=0 ; i--){


            if(max < a[i]){
                list.add(0,a[i]);
                max = a[i];
            }
        }
        return list;
    }
}
