package Bit_Manipulation;

public class Wheather_Num_Is_Odd_Or_Even {
    public static void main(String[] args) {

        int n = 66;

        if ((n & 1) == 1) System.out.println("Number is ODD");
        else System.out.println("Number is Even");
    }
}
