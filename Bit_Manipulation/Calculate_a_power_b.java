package Bit_Manipulation;

public class Calculate_a_power_b {
    public static void main(String[] args) {
        int a = 3;
        int b = 6;
        System.out.println(Math.pow(a,b));
        System.out.println(call(a, b));
    }
    public static int call(int a, int b){
        int base = 3;
        int ans = 1;

        while(b != 0){

            int temp = b&1;
            b = b>>1;

            if(temp  != 0 )
            ans = ans*(temp*base);
            base = base*base;

        }
        return ans;
    }
}
