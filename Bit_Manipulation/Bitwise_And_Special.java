package Bit_Manipulation;

public class Bitwise_And_Special {
    public static void main(String[] args) {
        int l = 5;
        int r = 7;
        System.out.println(call(l,r));
        System.out.println(call2(l,r));
    }
    public static int call(int l , int r){
        int count = 0;
        int ans = 0;

        while( l != r){
             l = (l>>1);
             r = (r>>1);
             count++;
        }

        while(count != 0 ){
            l = l<<1;
            count--;
        }
        return l;
    }
    public static int call2(int left , int right){
        int count=0;
        while(left!=right){
            left>>=1;
            right>>=1;
            count++;
        }
        return left<<=count;
    }
}
