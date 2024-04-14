package Sliding_Window;

public class Number_Of_SubArray_Sum_Equal_k {
    public static void main(String[] args) {
        int[]a = {0,0,0,0,0,0,0,0,0,0};
        int k = 0;

        System.out.println(call( a, k) - call(a ,k-1));
       // System.out.println(call2(a , k));

    }
    public static int call(int[]a , int k){
        int i = 0;
        int j = 0;
        int ans = 0;
        int sum = 0;


        while( j < a.length){
            sum += a[j];

            while(i <= j &&  sum > k){
                sum-=a[i];
                i++;
            }
            ans+=(j-i+1);
            j++;
        }
        return ans;
    }

}
