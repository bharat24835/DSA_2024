package Bit_Manipulation;

public class Find_Unique_ELement {
    public static void main(String[] args) {
        int[]a = {2,3,4,5,5,4,3};

        int unique = 0;
        for(int n : a){
            unique = unique^n;
        }
        System.out.println(unique);
    }
}
