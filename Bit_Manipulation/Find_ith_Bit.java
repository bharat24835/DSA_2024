package Bit_Manipulation;

public class Find_ith_Bit {
    public static void main(String[] args) {
        int n = 19;
        int ans = -1;
        int i = 2;
         ans = n&(1<<(i-1));
          // Remember  , we need to Unmask the bit to get particulat bit that number as well becasue it is necessary
        System.out.println(ans>>(i-1));
    }
}
