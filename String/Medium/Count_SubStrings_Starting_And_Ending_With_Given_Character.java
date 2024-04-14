package String.Medium;

import java.util.HashMap;
import java.util.Map;

public class Count_SubStrings_Starting_And_Ending_With_Given_Character {
    public static void main(String[] args) {
        String s = "abada";
        char c  = 'a';
        System.out.println(call(s , c));
    }
    public static long call(String s , char c){
        long count = 0;
        // charcter , count
        Map<Character , Integer>map = new HashMap<>();

        for(int i = 0 ; i<s.length(); i++){

            if(s.charAt(i) == c){
                count +=1 + (map.containsKey(c) ? map.get(c) : 0);
                map.put(c , map.getOrDefault(c , 0)+1);
            }
        }
        return count;
    }
}
