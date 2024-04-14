package Pointer_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Three_Sum_With_Simplicity {
    public static void main(String[] args) {
        int[]a = {1,1,2,2,3,3,4,4,5,5};
        int target = 8;
        System.out.println(call(a,target));
    }
    public static int call(int[]a, int target){
        int count = 0;

        Arrays.sort(a);
        int n = a.length;

        for(int x = 0 ; x<n-2 ; x++){

            int i =x+1;
            int j = n-1;

            while( i < j){
                int item_x = a[x];
                int item_i = a[i];
                int item_j = a[j];

                int temp = a[x] + a[i]+a[j];

                if(temp == target){
                    int count_1 = 1;
                    int count_2 = 1;

                    if(a[i] == a[j]){
                        int len = j-i+1;
                        // Simple Permutation And Combination
                        count += (len * (len-1))/2;
                        break;
                    }

                    while( i < j && a[i] == a[i+1]){
                        count_1++;
                        i++;
                    }
                    while( i < j && a[j] == a[j-1]){
                        count_2++;
                        j--;
                    }

                    count+= (count_1 * count_2);
                    i++;
                    j--;

                }
                else if(temp  < target) i++;
                else j--;



            }

        }
        return count;
    }
}
