package BacKTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation {
    public static void main(String[] args) {
        String s= "abc";
        System.out.println(call(s));
    }
    public  static List<String> call(String s){
        String temp = "";
        List<String> ans = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        call1(0 , s, temp, ans ,set);
        return ans;
    }
    public static void  call1(int i , String s, String temp , List<String>ans  ,Set<Character>set){
        if( i== s.length()){
            ans.add(new String(temp));
            return;
        }

        //
        for(int j = 0 ; j<s.length(); j++){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                call1(i+1, s , temp + s.charAt(j) , ans, set);
                set.remove(s.charAt(j));
            }
        }
    }
}
