package Sliding_Window;

import java.util.HashSet;
import java.util.Set;

public class Longest_Substring_With_No_Repeated_Characters {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(call(s));
    }
    public static int call(String s){
       int i = 0;
       int j  = 0 ;
       Set<Character> set = new HashSet<>();
       int max = 0;

       while( j < s.length()){
           char item = s.charAt(j);

           if(!set.contains(item)){
               set.add(item);
               max = Math.max(j-i+1 ,max );
           }
           else{
               while( i<s.length()&&   s.charAt(i) != s.charAt(j)){
                   set.remove(s.charAt(i));
                   i++;
               }
               // we reached the position on which we have reached
               // the positon where
               // first character and last character of window is same
               if(i<s.length())
               set.remove(s.charAt(i));
               i++;
               set.add(item);
           }
           j++;
       }
       return max;
    }
}
