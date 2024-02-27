package Bit_Manipulation;

public class Reset_ith_Bit {
    public static void main(String[] args) {
        int n  = 12;
        int i = 3;
        int mask = ~(1<<(i-1));
        System.out.println(n & mask);
    }
}
