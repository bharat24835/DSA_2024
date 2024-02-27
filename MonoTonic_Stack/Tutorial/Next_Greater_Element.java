package MonoTonic_Stack.Tutorial;

import java.util.Arrays;
import java.util.Stack;

public class Next_Greater_Element {
    public static void main(String[] args) {
        int[]arr = {13, 8, 1, 5, 2, 5, 9, 7, 6, 14};
        int[] result = findNextGreaterIndexes(arr);

//        for(int i =0 ; i<result.length;i++){
//            if(result[i] == -1) System.out.print("NULL,");
//            else
//            System.out.print(arr[result[i]]+", ");
//        }
        System.out.println("");
        System.out.println(Arrays.toString(result));

    }
    public static int[] findNextGreaterIndexes(int[] arr) {
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
