package String.Medium;

import java.util.ArrayList;
import java.util.List;

public class Min_Time_To_Revert_String_To_Initial_State {
    public static void main(String[] args) {
        String s = "abcbabcd";
        int  k = 2;
        System.out.println(call(s,k));
    }
    public static int call(String s, int k){
        int count =1;
        for(int i = k ; i<s.length(); i=i+k){
            if(call1(s,s.substring(i))) return count;
            count++;
        }
        return count;

    }
    public static boolean call1(String txt, String pattern){
        // first iniialise LPS Array
        int[]LPS = new int[pattern.length()];
        make_LPS(LPS,pattern);

        List<Integer>ans = new ArrayList<>();
        int i = 0 ;
        int j = 0;
        while( i <txt.length()){
            if(txt.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }
            if(j == pattern.length()){
                // we found the String
                ans.add(i-j);
                j = LPS[j-1];
            }
            else if( i<txt.length() &&  pattern.charAt(j) != txt.charAt(i)){
                if(j != 0 ){
                    j = LPS[j-1];
                }
                else {
                    i++;
                }
            }
        }
        for(int k = 0 ; k<ans.size(); k++){
            if(ans.get(k) == 0) return true;
        }
        return false;
    }
    public static void make_LPS(int[]LPS, String pattern){
        LPS[0] = 0;
        int length = 0;
        int i =1 ;
        while(i < pattern.length()){

            if(pattern.charAt(i) == pattern.charAt(length)){
                length++;
                LPS[i] = length;
                i++;
            }
            else {
                if(length!=0){
                    length = LPS[length-1];

                }
                else{
                    LPS[i] = 0;
                    length = 0;
                    i++;
                }
            }
        }
    }
}
