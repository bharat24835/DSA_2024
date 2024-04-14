package String.Medium;

import java.util.Arrays;
import java.util.Stack;

public class Valid_Parenthesis_String {
    public static void main(String[] args) {
        /**
         * Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
         *
         * The following rules define a valid string:
         *
         * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
         * Any right parenthesis ')' must have a corresponding left parenthesis '('.
         * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
         * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
         */
        String s=  "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()";
        System.out.println(call(s));
        System.out.println(call1(s));
        System.out.println(call2(s));
    }

    public static boolean call2(String s){
        int n  = s.length();
        boolean[][]dp =new boolean[n+1][n+1];
        // fill out base case for that
        dp[n][0] = true;
        for(int i = n-1 ; i>=0 ; i--){
            for(int open = 0 ; open<n ; open++){
                boolean isValid = false;
                if(s.charAt(i) == '('){
                    isValid |= dp[i+1][open+1];
                }
                else if (s.charAt(i) == '*'){
                    isValid |= dp[i+1][open+1];
                    isValid |= dp[i+1][open];
                    if(open > 0){
                        isValid |= dp[i+1][open-1];
                    }
                }
                else if(open > 0){
                    isValid |= dp[i+1][open-1];
                }

                dp[i][open] = isValid;
            }
        }
        return dp[0][0];
    }

    public static boolean call(String s){
        Stack<Integer> st = new Stack<>(); // tracks open bracket
        Stack<Integer>astrik = new Stack<>();

        for(int i = 0 ; i<s.length() ; i++){
            if(s.charAt(i) == '('){
                st.push(i);
            }
            else if (s.charAt(i) == '*'){
                astrik.push(i);
            }
            else if(s.charAt(i) == ')'){
                if(!st.isEmpty())  st.pop();
                else if (!astrik.isEmpty()) astrik.pop(); // closing braket ko open bracket chaiye , par usse pehlai anaa chaiye
                else return false;
            }
        }
        while(!st.isEmpty()){
            // opening bracket ko closing bracker solve kar sakta hai
            // far usk baad anaa chahiye
            // so we wish to find astrik jo uska baad aee hoo
            int index = st.pop();
            if(!astrik.isEmpty() && astrik.peek() > index){

                astrik.pop();
            }
            else return false;

        }
        return true;

    }

    public static boolean call1(String s){
        int n = s.length();
        int[][]dp = new int[n][n];
        for(int[]b: dp){
            Arrays.fill(b, -1);
        }
        return dp1(0 , 0 , dp , s);
    }
    public static boolean dp1(int i , int open , int[][]dp  , String s){
        if( i == s.length()){
            return open== 0;
        }
        if(dp[i][open] != -1) return dp[i][open] == 1 ? true:false;

        boolean isValid = false;
        if(s.charAt(i) == '('){
            isValid |= dp1(i+1 , open+1 , dp ,s);
        }
        else if(s.charAt(i) == '*'){
            isValid |= dp1(i+1 , open+1 , dp , s); // '*' => '('
            isValid |= dp1(i+1 , open ,dp, s ); // '*' => ''
            if (open > 0)
                isValid |=  dp1(i+1 , open-1 , dp , s); // '*' => ')'
        }
        else if (open > 0){
            isValid |= dp1(i+1 , open-1 , dp , s);
        }
        dp[i][open] = isValid ? 1 : 0;
        return isValid;
    }


}
