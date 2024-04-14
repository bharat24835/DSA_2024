package MonoTonic_Stack.Tutorial;

import java.util.Arrays;
import java.util.Stack;

public class Next_Smaller {
    public static void main(String[] args) {
        int[]a ={13, 8, 1, 5, 2, 5, 9,9, 7, 6, 12};
        int[]result = findNextSmaller(a);
        System.out.println(Arrays.toString(result));
    }
    public static int[] findNextSmaller(int[]a){
        Stack<Integer>st = new Stack<>();
        int[]nextSmaller = new int[a.length];
        Arrays.fill(nextSmaller,-1);

        // voh particular Elemetn a[i], kisk liye NextSmaller ELment hoga
        // Previus stored elemnet which are greater than a[i] , for them a[i]  will be the Next Smaller Elemet
        for(int i = 0 ; i<a.length; i++){

            while(!st.isEmpty() && a[st.peek()] > a[i]){
                int stackTop = st.pop();
                nextSmaller[stackTop] = i;

            }
            st.push(i);
        }
        return nextSmaller;
    }
}
