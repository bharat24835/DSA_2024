package String.Medium;

import java.util.Stack;

public class Remove_K_Digits {
    public static void main(String[] args) {
        String num = "675645";
        int k = 3;
        System.out.println(call(num , k));
    }
    public static String call(String s  , int k ){
        if(s.length() == k) return new String("0");
       Stack<Integer>st = new Stack<>();

       for(int i = 0 ; i<s.length() ; i++){
           int num = s.charAt(i)-'0';

           while(!st.isEmpty() && st.peek() > num && k>0){
               st.pop();
               k--;
           }
           if(st.isEmpty() && num == 0 )continue;   // code rum (num  = 10200 , k = 1)
           st.push(num);
       }
       // maan log string Puri Increasing Order hai
        while(!st.isEmpty() && k > 0){
            st.pop();
            k--;
        }

       StringBuilder ans = new StringBuilder();
       while(!st.isEmpty()){
           int item = st.pop();
           ans.insert( 0 ,item);
       }
       return ans.length() == 0 ? new String("0"): ans.toString();
    }
}
