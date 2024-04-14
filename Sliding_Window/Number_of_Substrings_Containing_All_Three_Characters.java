package Sliding_Window;

import java.util.Arrays;

public class Number_of_Substrings_Containing_All_Three_Characters {
    public static void main(String[] args) {

        /**
         * Given a string s consisting only of characters a, b and c.
         * Return the number of substrings containing at least one occurrence of all these characters a, b and c.
         */
        String s = "aaacb";
        System.out.println(call(s));
    }
    public static int call(String s){
       int[]temp = new int[3];
        Arrays.fill(temp , -1);

        int ans  =0;
        int min = Integer.MAX_VALUE;
        int count = 0;

        for(int i = 0 ; i<s.length(); i++){
            if(temp[s.charAt(i) -'a'] == -1){
                temp[s.charAt(i) -'a'] = i;
                count++;
            }
            else{
                temp[s.charAt(i) -'a'] = i;
            }
            min = Math.min(temp[0] , Math.min(temp[2] , temp[1]));

            ans += count==3 ? min+1:0;

        }
        return ans;
    }
}
