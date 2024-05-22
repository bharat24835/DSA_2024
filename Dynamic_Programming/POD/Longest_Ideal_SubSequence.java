package Dynamic_Programming.POD;

public class Longest_Ideal_SubSequence {
    public static void main(String[] args) {
        String s = "abcd";
        int k = 3;

        System.out.println(call(  0 , s, k));
    }
    public static int call(int i , String s, int k){
        if( i == s.length() )return 0;

        int ans = 0;
        for(int j = i+1 ; j<s.length() ; j++){
            if(j < s.length() && Math.abs(s.charAt(j) - s.charAt(i)) <=2 ){
                int temp = 1 + call(j , s, k);
                ans = Math.max(ans , temp);
            }
        }
        return ans;
    }
}
