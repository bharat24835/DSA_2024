package MonoTonic_Stack.Code;

import java.util.Arrays;
import java.util.Stack;

public class Previous_Greater_Element {
    public static void main(String[] args) {
        int[]a = {13, 8, 1, 5, 2, 5, 9, 7, 6, 14};
        int[]temp = call(a);
        System.out.println(Arrays.toString(temp));
    }
    public static int[]call(int[]a){
        int[]temp = new int[a.length];
        int n  = a.length;

        Stack<Integer> st = new Stack<>();
        for(int i =0 ; i<n ; i++){

            int item = a[i];

            while(!st.isEmpty() && a[st.peek()] <= a[i]){
                st.pop();
            }

            if(st.isEmpty()) temp[i] = -1;
            else temp[i] =a[st.peek()];

            st.push(i);

        }
        return temp;
    }
}
