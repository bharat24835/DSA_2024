package MonoTonic_Stack.Questions;

import java.util.Arrays;
import java.util.Stack;

public class Largest_Recangle_HistoGram {
    public static void main(String[] args) {
        int[]a = {2,0,2};
        System.out.println(call(a));
    }
    public static int call(int[]a){
        int[]nse = findNextSmaller(a);
        int[]pse = findPrevius_Smaller(a);
        int max = 0 ;
        for(int i = 0 ; i<a.length ; i++){
            int height = a[i];
            int width = nse[i] - pse[i] - 1;
            max = Math.max(max , height*width);

        }
        return max;
    }
    public static int[] findNextSmaller(int[]a){
        Stack<Integer>st = new Stack<>();
        int[]nextSmaller = new int[a.length];
        Arrays.fill(nextSmaller,a.length);

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
    public static int[] findPrevius_Smaller(int[]a){
        Stack<Integer> st = new Stack<>();
        int[]previous_smaller= new int[a.length];
        Arrays.fill(previous_smaller,-1);

        for(int i = 0 ; i<a.length; i++){

            while(!st.isEmpty() && a[st.peek()] >= a[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                previous_smaller[i] = st.peek();
            }
            st.push(i);
        }
        return previous_smaller;
    }
}
