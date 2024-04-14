package Array.Medium;

import java.util.Arrays;

public class Product_Of_Array_Except_Self {
    public static void main(String[] args) {
        int[]a = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(call(a)));
    }
    public static int[] call(int[]a){
            int n = a.length;
            int[]temp = new int[n];
            Arrays.fill(temp,1);

            int product = 1;

            for(int i = 0 ; i<n ; i++){
                int item = a[i];
                temp[i] = product;
                product = product*item;
            }
            product =1;
            for(int i = n-1 ; i>=0 ; i--){
                int item = a[i];
                temp[i] = temp[i]*product;
                product = product*item;
            }
            return temp;
    }
}
