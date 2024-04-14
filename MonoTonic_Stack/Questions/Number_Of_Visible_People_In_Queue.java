package MonoTonic_Stack.Questions;

import java.util.Arrays;
import java.util.Stack;

public class Number_Of_Visible_People_In_Queue {
    public static void main(String[] args) {
        int[]a = {10,6,8,5,11,9};
        System.out.println(Arrays.toString(canSeePersonsCount(a)));
    }
    public static int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[heights.length];
        // since all elements in the array are unique then

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {

                // next greater section
                int stackTop = stack.pop();
                // process
                answer[stackTop]++;
            }
            if (!stack.isEmpty()) {
                // previous greater section
                // process
                answer[stack.peek()]++;
            }
            stack.push(i);
        }

        return answer;
    }
}
