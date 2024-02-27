package MonoTonic_Stack.Tutorial;

import java.util.Arrays;
import java.util.Stack;

public class Next_Greater_Previous_Greater_In_One_Go {
    public static int[] previousGreater;
    public static int[] nextGreater;
    public static void main(String[] args) {
        int[]a = {13, 8, 1, 5, 2, 5, 9, 7, 6, 14};
        findNextAndPreviousGreaterIndexes(a);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(previousGreater));
        System.out.println(Arrays.toString(nextGreater));



    }
    public static void findNextAndPreviousGreaterIndexes(int[] arr) {
        Stack<Integer> stack = new Stack<>();
         previousGreater = new int[arr.length];
         nextGreater = new int[arr.length];
        Arrays.fill(previousGreater, -1);
        Arrays.fill(nextGreater, -1);

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                int stackTop = stack.pop();
                nextGreater[stackTop] = arr[i];
            }
            if (!stack.isEmpty()) {
                previousGreater[i] = arr[stack.peek()];
            }
            stack.push(i);
        }

    }
}
