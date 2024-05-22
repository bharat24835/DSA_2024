package Contest_LeetCode.April_27;

public class Question1 {
    public static void main(String[] args) {
        char[][]a  = {{'B' ,'W' , 'B'} , {'B' , 'W' , 'W'} , {'B' , 'W' , 'B'}};
        System.out.println(call(a));
    }
    public static boolean call(char[][]a){
        // look there are only 4 subarray of 2*2 in 3*3
        // lookign for group1
        int countB= 0;
        int countW= 0;
        if(a[0][0] == 'B' )countB++;
        else countW++;
        if(a[0][1] == 'B')countB++;
        else countW++;
        if(a[1][0] == 'B')countB++;
        else countW++;
        if(a[1][1] == 'B')countB++;
        else countW++;
        if(Math.abs(countB - countW)>=1) return true;
        countB= 0;
        countW= 0;
        if(a[0][1] == 'B' )countB++;
        else countW++;
        if(a[0][2] == 'B')countB++;
        else countW++;
        if(a[1][1] == 'B')countB++;
        else countW++;
        if(a[1][2] == 'B')countB++;
        else countW++;
        if(Math.abs(countB - countW)>=1) return true;
        countB= 0;
        countW= 0;
        if(a[1][0] == 'B' )countB++;
        else countW++;
        if(a[1][1] == 'B')countB++;
        else countW++;
        if(a[2][0] == 'B')countB++;
        else countW++;
        if(a[2][1] == 'B')countB++;
        else countW++;
        if(Math.abs(countB - countW)>=1) return true;
        countB= 0;
        countW= 0;
        if(a[1][1] == 'B' )countB++;
        else countW++;
        if(a[1][2] == 'B')countB++;
        else countW++;
        if(a[2][1] == 'B')countB++;
        else countW++;
        if(a[2][2] == 'B')countB++;
        else countW++;
        if(Math.abs(countB - countW)>=1) return true;

        return false;
    }
}
