package MonoTonic_Stack.Questions;

import java.util.Arrays;
import java.util.Stack;

public class Daily_Temp {
    public static void main(String[] args) {
        int[]a ={73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(call(a)));
    }
    public static int[] call(int[] arr) {
        // initialize an empty stack
        Stack<Integer> stack = new Stack<>();

        int[] nextGreater = new int[arr.length];
        Arrays.fill(nextGreater, -1);

        for (int i = 0; i < arr.length; i++) {

            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {

                int stackTop = stack.pop();
                // as given in the condition of the while loop above,
                // nextGreater element of stackTop is the element at index i
                nextGreater[stackTop] = arr[i];
            }
            // push the current element
            stack.push(i);
        }
        return nextGreater;
    }
}
