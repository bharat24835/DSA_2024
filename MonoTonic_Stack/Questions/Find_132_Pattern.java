package MonoTonic_Stack.Questions;

import java.util.Arrays;
import java.util.Stack;

public class Find_132_Pattern {
    public static void main(String[] args) {
        int[]a ={1,-4,2,-1,3,-3,-4,0,-3,-1};
        System.out.println(call(a));
    }
    public static boolean call(int[]a){
        System.out.println(call1(a));
         return find132pattern(a);
    }
    public static boolean find132pattern(int[] nums) {
        int[] minimums = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            // Setup minimums
            if (i == 0) {
                minimums[i] = 0;
            } else {
                minimums[i] = (nums[i] < nums[minimums[i - 1]]) ? i : minimums[i - 1];
            }

            // Using template for finding previous greater elements

            // Find previous greater element, build monotonic decreasing stack
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }

            // If there is a previous greater element, stack will not be empty
            if (!stack.isEmpty()) {
                // If the previous minimum for the previous greater element is
                // less than the current number, then we return true
                if (nums[minimums[stack.peek()]] < nums[i]) {
                    return true;
                }
            }

            stack.push(i);
        }

        return false;
    }

    public static boolean call1(int[]a){
        int[]pge = new int[a.length];
        makepge(pge, a);
        int[]min = new int[a.length]; // it store min(in term of index) upto the current index

        for(int i = 0 ; i<a.length; i++){
            if(i == 0) min[0] = 0;
            else min[i] = (a[i] < a[min[i-1]] ? i : min[i-1]);

            if(pge[i] != -1){
                int pgi = pge[i];
                int pmin = min[pgi];
                if(a[pmin] < a[i]) return true;
            }

        }
        return false;
    }
    public static void makepge(int[]pge , int[]a){
        Arrays.fill(pge, -1);
        Stack<Integer>st = new Stack<>();
        for(int i =0; i<a.length; i++ ){

            while(!st.isEmpty() && a[st.peek()] <= a[i]){
                st.pop();
            }

            if(!st.isEmpty()) pge[i] = st.peek();

            st.push(i);
        }
    }
}
