package MonoTonic_Stack.Questions;

import java.util.Arrays;
import java.util.Stack;

public class Next_Greater_Element_2 {
    public static void main(String[] args) {
        int[]a = {13, 8, 1, 5, 2, 5, 9, 7, 6, 14};
        System.out.println(Arrays.toString(nextGreaterElements(a)));
        System.out.println(Arrays.toString(nextGreaterCircular(a)));
    }

               //  Iterating from Last
    public static int[] nextGreaterElements(int[] a) {

        int [] nge = new int[a.length];
        Stack<Integer> st = new Stack<>();
        int n = a.length;
        for(int i = 2*n-1; i>=0 ; i--){

            while(st.empty()==false && st.peek()<=a[i%n])
            { st.pop();
            }
            if(i<n){
                if(st.empty()==false)
                    nge[i] = st.peek();
                else
                    nge[i]=-1;
            }
            st.push(a[i%n]);
        }
        return nge;

    }

       // Iterating from First
    public static int[] nextGreaterCircular(int[] arr) {

        int[] nextGreater = new int[arr.length];
        Arrays.fill(nextGreater, -1);

        Stack<Integer> stack = new Stack<>();

        // Run the outer loop two times
        for (int j = 0; j < 2; j++) {
            // Run the inner loop to iterate through each element of the array
            for (int i = 0; i < arr.length; i++) {
                // Use a while loop to check the stack condition
                while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                    int stackTop = stack.pop();
                    nextGreater[stackTop] = arr[i];
                }
                stack.push(i);
            }
        }

        return nextGreater;
    }
}
