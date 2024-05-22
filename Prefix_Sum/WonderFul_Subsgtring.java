package Prefix_Sum;

import java.util.HashMap;
import java.util.Map;

public class WonderFul_Subsgtring {
    public static void main(String[] args) {
        String s = "aba";
        System.out.println(call(s));
    }
    public static long call(String word){
        int n = word.length();
        Map<Integer , Integer> map = new HashMap<>();
        map.put(0 , 1);
        long ans   = 0;
        int xor = 0;
        for(int i = 0 ; i<n; i++){
            int shift = (int)word.charAt(i)-'a';
            // 1<<shift is binary representation of character
            xor ^= (1<<shift);

            if(map.containsKey(xor)){
                ans+=map.get(xor);
            }
            // now we need to calculate for odd
            for(char j = 'a' ; j<= 'j' ;j++){
                int shift2 =  j - 'a';
                int temp = xor^(1<<shift2);
                if(map.containsKey(temp)){
                    ans+=map.get(temp);
                }
            }

            map.put(xor , map.getOrDefault(xor , 0)+1);
        }
        return ans;


    }
}
