package POD_LEETCODE;

import java.util.Arrays;

public class Move_Zeroes_To_End {
    public static void main(String[] args) {
        int[]a = {1, 2, 0, 4, 3, 0, 5, 0};
        call(a);
        System.out.println(Arrays.toString(a));
    }
    public static void call(int[]a){
        // pointer questio
        int count = 0;

        for(int i  = 0 ; i<a.length ; i++){

            if(a[i]!= 0){
                a[count++] = a[i];

            }


        }

        while(count < a.length){
            a[count++] = 0;
        }

    }
}
