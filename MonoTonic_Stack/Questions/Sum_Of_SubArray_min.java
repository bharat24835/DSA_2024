package MonoTonic_Stack.Questions;

import java.util.Arrays;
import java.util.Stack;

public class Sum_Of_SubArray_min {
    public  static  long mod = (int)1000000007;
    public static void main(String[] args) {
        int[]a = {3,1,2,4};
        System.out.println(call(a));
    }
    public static int call(int[]a){
        long ans = 0;
        int[]pse = find_pse(a);
        int[]nse = find_nse(a);
        System.out.println(Arrays.toString(pse));
        System.out.println(Arrays.toString(nse));
        //int ans = 0;

        for(int i = 0 ; i<a.length; i++){
            int left = i - pse[i];
            int right = nse[i] - i;

            long ways = (left*right)%mod;

            ans =  ((ans%mod) + (a[i]* ways)%mod)%mod;
        }
        return (int)ans;

    }
    public  static int[] find_nse(int[]a){
        int[]ans = new int[a.length];
        Arrays.fill(ans , a.length);
        Stack<Integer>st = new Stack<>();

        // next
        // inside while loop
        // not equal for strict
        // no equal allowed for not strict
        // ans[st.pop()] = i;

        // smaller
        // a[i] < a[st.peek()]

        for(int i = 0 ; i<a.length; i++){

            while(!st.isEmpty() && a[i] <= a[st.peek()]){
                int stTop = st.pop();
                ans[stTop] = i;
            }
            st.push(i);
        }
        return ans;
    }
    public static int[] find_pse(int[]a){
        int[]ans = new int[a.length];
        Arrays.fill(ans, -1);
        // previous
        // outside while loo
        // equal for strict
        // no equal not allowed
        // ans[i] = st.peek()

        // smaller
        // a[i] <= a[st.peek()]

        Stack<Integer>st = new Stack<>();

        for(int  i = 0 ; i<a.length; i++){

            while(!st.isEmpty() && a[i] <= a[st.peek()]){
                st.pop();
            }
            if(!st.isEmpty()){
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return  ans;
    }
}
