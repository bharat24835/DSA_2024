package Sliding_Window;

public class SubArray_Product_Less_Than_K {
    public static void main(String[] args) {
        int[]a = {10,5,2,6};
        int k = 100;
        System.out.println(call(a , k));
    }
    public static int call(int[]a , int k){
        int count =0;
        int i = 0;
        int j = 0;
        int product = 1;

        while( j < a.length){
            product*=a[j];

            while(i<=j && product >= k){
                product/=a[i];
                i++;
            }
            if(product < k){
                count+=(j-i+1);
            }
            j++;
        }
        return count;
    }

}
