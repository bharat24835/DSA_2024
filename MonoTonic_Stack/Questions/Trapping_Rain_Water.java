package MonoTonic_Stack.Questions;

import java.util.Arrays;
import java.util.Stack;

public class Trapping_Rain_Water {
    public static void main(String[] args) {
        int[]a = {4,2,3};
        System.out.println(trap(a));
        System.out.println(call(a));
    }

    public static int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                int stackTop = stack.pop();
                if (!stack.isEmpty()) {
                    // h (height) is the minimum of the previous greater or the next greater elements
                    int h = Math.min(height[stack.peek()], height[i]) - height[stackTop];

                    // w (width) is the space between next greater and previous greater element
                    int w = i - (stack.peek() + 1);

                    // h * w is the area this stackTop contributes
                    count += h * w;
                }
            }
            stack.push(i);
        }

        return count;
    }

    public static int call(int[]a){
        // finding the next greater or equal to Element for current number;
        int n = a.length;
        int[]nge = new int[n];
        long[]prefix = new long[n];
        makePrefix(prefix,a);
        make_nge(nge, a);
        int sum = 0 ;
        System.out.println(Arrays.toString(nge));


        int i = 0;

        while( i<a.length){
            if(a[i] == 0 || nge[i] == -1) {
                i++;
            }
            else{
                int ngIndex = nge[i];
                int gap = (int) (prefix[ngIndex] - prefix[i] - a[ngIndex]);
                int width = ngIndex-i-1;
                int length = Math.min(a[i] , a[ngIndex]);
                sum+= (length*width) - gap;

                i = ngIndex;
            }

        }


        return sum;
    }
    public static void makePrefix(long[]prefix , int[]a){
        long sum = 0 ;
        prefix[0] = a[0];
        for(int i = 1 ; i<a.length ; i++){
            prefix[i] = prefix[i-1] + a[i];
        }
    }
    public static void make_nge(int[]nge, int[]a){
        int n   = a.length;
        Arrays.fill(nge,-1);
        Stack<Integer>st = new Stack<>();
        for(int i = 0 ; i<n ; i++){
            while(!st.isEmpty() && a[st.peek()] <= a[i]){
                int stTop = st.pop();
                nge[stTop] = i;
            }
            st.push(i);
        }

    }
}
