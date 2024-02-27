package MonoTonic_Stack.Questions;

import java.util.Arrays;
import java.util.Stack;

public class Building_With_Ocena_View {
    public static void main(String[] args) {
        int[]a = {4,3,5,6,7,10,1,2};
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
