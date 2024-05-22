package MonoTonic_Stack.Questions;

import java.util.Arrays;
import java.util.Stack;

public class Sum_Of_SubArray_Ranges {
    public  static  long mod = (int)1000000007;
    public static void main(String[] args) {
        int[]a ={1,3,3};
        System.out.println(call(a));
    }
    public static long call(int []a){
        System.out.println( "Larger answer is  :" + call1(a));
        System.out.println("Smaller Anser is  : "+ call2(a));
        return call1(a) - call2(a);
        // call1 for finding largest element in every array
        // call2 for finding smaller element in every array

    }
    public static long call1(int[]a){
        // finding largest elenet in every array
        // for that we need nge and pge
        int[]nge = find_nge(a);
        int[]pge = find_pge(a);
        long answer = 0;
        for(int i = 0 ; i<a.length ; i++){
            answer += ((long)(i-pge[i])*(long)(nge[i]-i))%mod * a[i]%mod;
            answer%=mod;
        }
        return answer;


    }
    public static long call2(int[]a){
        // find smaller element for all subarray
        // for that we need nse , pse
        int[]nse = find_nse(a);
        int[]pse = find_pse(a);
        long answer = 0;
        for(int i = 0 ; i<a.length ; i++){
            answer += ((long)(i-pse[i])*(long)(nse[i]-i))%mod * a[i]%mod;
            answer%=mod;
        }
        return answer;

    }
    public static int[]find_nge(int[]a){
        int[]ans = new int[a.length];
        // next
        // inside while loop , no equal for strict , equal allowed , a[st.pop()] = i;
        // greater :- a[i]> a[st.peek()]

        Arrays.fill(ans, a.length);
        Stack<Integer>st = new Stack<>();

        for(int i= 0 ; i<a.length ;i++){
            while ((!st.isEmpty()) && a[i] >= a[st.peek()]){
                int st_top =st.pop();
                ans[st_top ] = i;
            }
            st.push(i);
        }
        return ans;
    }

    public static int[]find_pge(int[]a){
        int[]ans = new int[a.length];
        Stack<Integer>st = new Stack<>();
        Arrays.fill(ans, -1);
        // previous
        // outisde while loop , equal for stict , (no equal)  not allowed  , ans[i] = st.peek;
        // greater a[i] > a[st.peek()]

        for(int i= 0 ; i<a.length ; i++){
            while (!st.isEmpty() && a[i] >= a[st.peek()]){
                st.pop();
            }
            if(!st.isEmpty())
                ans[i] = st.peek();
            st.push(i);
        }
        return ans;
    }

    public static int[]find_nse(int[]a){
        int[]ans = new int[a.length];
        Stack<Integer>st = new Stack<>();
        Arrays.fill(ans , a.length);
        // next
        // inside while loop , no equal for stict  , equal allowed  , a[st.pop()] = i;
        // smaller
        // a[i] < a[st.peek()]
        for(int i = 0  ; i<a.length ; i++){
            while (!st.isEmpty() && a[i] <= a[st.peek()]){
                int stTop = st.pop();
                ans[stTop] = i;
            }
            st.push(i);
        }
        return ans;
    }

    public static int[]find_pse(int[]a){
        int[]ans = new int[a.length];
        Stack<Integer>st = new Stack<>();
        Arrays.fill(ans , -1);
        // previous
        // outside while loop , equal for struct , no equal not allowed , ans[i] = st.peek();
        // smakker a[i] < a[st.peek()];

        for(int i = 0 ; i<a.length ; i++){
            while (!st.isEmpty() && a[i] <= a[st.peek()]){
                st.pop();
            }
            if(!st.isEmpty()){
                ans[i] = st.peek();
            }
            st.push(i);

        }
        return ans;
    }
}
