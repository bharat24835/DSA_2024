package Bit_Manipulation;

public class Find_Number_Of_Digits_In_Base_B {
    public static void main(String[] args) {
        int n = 6;
        int b = 2;

        System.out.println((int)(Math.log(n) / Math.log(b)) +1 );
    }
}
