package String.Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Isomorphic_String {
    public static void main(String[] args) {
      String s = "badc";
     // String s = "paper";
      String t = "baba";
     // String t = "title";
        System.out.println(isIsomorphic(s ,t));
    }
    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character , Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for(int i = 0  ; i<s.length() ; i++){
            char temp = s.charAt(i);
            if(map.containsKey(temp)){
                if(map.get(temp) != t.charAt(i)) return false;
            }
            else{
                if(set.contains(t.charAt(i))) return false;
                map.put(temp , t.charAt(i));
                set.add(t.charAt(i));
            }
        }
        return true;

    }
}
