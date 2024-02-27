package MonoTonic_Stack.Tutorial;

import java.util.Arrays;
import java.util.Stack;

public class Previous_Greater_Element {
    public static void main(String[] args) {
        int[]a = {13, 8, 1, 5, 2, 5, 9, 7, 6, 14};
        int[]temp = findPreviousGreaterIndexes(a);
        System.out.println(Arrays.toString(a));
        for(int i =0 ;  i<a.length; i++){
            if(temp[i] == -1){
                System.out.print("Null,");
            }
            else System.out.print(a[temp[i]]+",");
        }
        System.out.println("");
        System.out.println(Arrays.toString(temp));

    }
    public static int[] findPreviousGreaterIndexes(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] previousGreater = new int[arr.length];
        Arrays.fill(previousGreater,-1);

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                previousGreater[i] = stack.peek();
            }
            stack.push(i);
        }
        return previousGreater;
    }
}
