package Array.Medium;

import java.util.Arrays;
import java.util.Stack;

public class Max_Rectangle {
    public static void main(String[] args) {
        char[][]a ={{'1','0','1','0','0'}, {'1','0','1','1','1'} , {'1','1','1','1','1'}, {'1','0','0','1','0'}};
        System.out.println(call(a));
    }
    public static int call(char [][]a){
        int[]temp = new int[a[0].length];
        int max = 0;
        // filling the base case
        for(int i = 0 ; i<a.length ; i++){
            for(int j =0 ; j<a[i].length ; j++){
                if(a[i][j] == '1') temp[j]  +=1;
                else temp[j] = 0;
            }

            // find next smaller and previouse smaller for that temp array
            int[]nse = findNextSmaller(temp);
            int[]pse = findPrevius_Smaller(temp);
            for(int j = 0 ; j<a[i].length ; j++){
                int height = temp[j];
                int width = nse[j] - pse[j] - 1;
                max = Math.max(max , height*width);

            }

        }
        return max;

        //
    }
    public static int[] findNextSmaller(int[]a){
        Stack<Integer> st = new Stack<>();
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
