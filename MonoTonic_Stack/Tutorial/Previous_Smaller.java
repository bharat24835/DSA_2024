package MonoTonic_Stack.Tutorial;

import java.util.Arrays;
import java.util.Stack;

public class Previous_Smaller {
    public static void main(String[] args) {
        int[]a ={13, 8, 1, 5, 2, 5, 9,9, 7, 6, 12};
        int[]result = findPrevius_Smaller(a);
        System.out.println(Arrays.toString(result));
    }
    public static int[] findPrevius_Smaller(int[]a){
        Stack<Integer>st = new Stack<>();
        int[]previous_smaller= new int[a.length];
        Arrays.fill(previous_smaller,-1);

        for(int i = 0 ; i<a.length; i++){

            while(!st.isEmpty() && a[st.peek()] >= a[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                previous_smaller[i] = st.peek();
            }
            st.push(i);
        }
        return previous_smaller;
    }
}
