package MonoTonic_Stack.Code;

import java.util.Arrays;
import java.util.Stack;

public class Next_Greater_Element {
    public static void main(String[] args) {
        int[]a = {13,8,1,5,5,5,5,5};
        int[]temp  =call(a);

//        for(int i = 0 ; i<a.length; i++){
//            if(temp[i] == -1)
//                System.out.print("Null,");
//            else System.out.print(a[temp[i]]+",");
//        }
        System.out.println();
        System.out.println(Arrays.toString(temp));
    }
    public static int[]call(int[]a){
        int[]temp = new int[a.length];
        int n = a.length;

        Stack<Integer> st = new Stack<>();
        for(int i = a.length-1; i>=0; i--){
               int item = a[i%n];
            // first we need to remove the stack TOp Elemetn who are lesser than or  equal to the number
            while(!st.isEmpty() && a[st.peek()] <= a[i%n] ){
                st.pop();
            }

           if(i < a.length){
               if(st.isEmpty()){
                   temp[i%n] = -1;
               }
               else temp[i%n] = a[st.peek()];
           }
            st.push(i%n);

        }
        return temp;
    }
}
