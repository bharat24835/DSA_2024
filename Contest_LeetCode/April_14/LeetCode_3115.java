package Contest_LeetCode.April_14;

public class LeetCode_3115 {
    public static void main(String[] args) {
        int[]a = {4,2,9,5,3};
        System.out.println(call(a));

    }
    public static int call(int[]a){
        int i = 0;
        int j  = a.length-1;

        while(i <= j){
            boolean ith = isPrime(a[i]);
            boolean jth = isPrime(a[j]);
            if(ith && jth) return j-i;
            if(!ith) i++;
            if(!jth) j--;
        }
        return 0;
    }

    public static boolean isPrime(int number) {
        // Check if the number is less than or equal to 1
        if (number <= 1) {
            return false;
        }

        // Check if the number is divisible by any number from 2 to its square root
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        // If the number is not divisible by any number from 2 to its square root, then it is prime
        return true;
    }
}
