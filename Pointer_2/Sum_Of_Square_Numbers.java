package Pointer_2;

public class Sum_Of_Square_Numbers {
    public static void main(String[] args) {
        int n = 1000000;
        System.out.println(call(n));
    }
    public static boolean call(int n){

        long left = 0;
        long right = n-1;

        while(left < right){

            long lsum = left*left;
            long rsum = right*right;
            long sum = lsum + rsum;
            if(sum > n) right--;
            else if(sum < n) left++;
            else return true;
        }
        return false;
    }
}
