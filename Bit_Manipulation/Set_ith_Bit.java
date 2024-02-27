package Bit_Manipulation;

public class Set_ith_Bit {
    public static void main(String[] args) {
        int n = 5;
        int i=2;
        int mask = (1<<(i-1));
        System.out.println(n | mask);
    }
}
