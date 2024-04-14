package Pointer_2;

public class Min_Length_of_String_After_Deleteing_Similar_Ends {
    public static void main(String[] args) {
     //   String s = "bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb";
        String s = "bbbbbbbbbbbbbbbbbbb";
        System.out.println(call(s));
    }
    public static int call(String s){
        int n = s.length();
        int count  = s.length();
        int i = 0;
        int j = n-1;


        while( i < j){
            char char_i = s.charAt(i);
            char char_j = s.charAt(j);
            if(char_j != char_i) return j-i+1;

            while(i< n && s.charAt(i) == char_j)  i++;
            while(j>=0 && s.charAt(j) == char_i)  j--;

            count = Math.min(char_i , j-i+1);
        }

        return count > 0  ? count : 0;

    }
}
