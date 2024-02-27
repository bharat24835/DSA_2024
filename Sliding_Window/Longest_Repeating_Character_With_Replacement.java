package Sliding_Window;

public class Longest_Repeating_Character_With_Replacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(call(s, k));
    }
    public static int call(String s, int k){
        int i = 0;
        int j = 0;
        int[]temp = new int[26];
        int ans = 0;
        int maxRepeat = 0;

        while(j < s.length()){
            char item = s.charAt(j);
            temp[item-'A']++;
            maxRepeat = Math.max(maxRepeat, temp[item-'A']);


            if(j-i+1 - maxRepeat > k){
                char first = s.charAt(i);
                temp[first-'A']--;
                i++;
            }

            ans = Math.max(ans , j-i+1);
            j++;
        }
        return ans;
    }
}
