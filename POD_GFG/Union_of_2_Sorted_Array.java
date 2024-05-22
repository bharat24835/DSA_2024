package POD_GFG;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Union_of_2_Sorted_Array {
    public static void main(String[] args) {
        int[]a ={1,1,1};
        int[]b={2,2,2};

        System.out.println(call(a, b));
    }
    public static ArrayList<Integer>call(int[]a , int[]b){
       ArrayList<Integer>ans = new ArrayList<>();
       Set<Integer> st = new HashSet<>();

      int i = 0;
      int j = 0;
      while (i < a.length && j < b.length){

          if(a[i] < b[j]){
              if(!st.contains(a[i])){
                  ans.add(a[i]);
                  st.add(a[i]);
              }
              i++;
          }
          else if(a[i] > b[j]){
              if(!st.contains(b[j])){
                  ans.add(b[j]);
                  st.add(b[j]);
              }
              j++;
          }
          else{
              if(!st.contains(a[i])){
                  ans.add(a[i]);
                  st.add(a[i]);
              }
              i++;
              j++;
          }
      }

      while(i < a.length){
          if(!st.contains(a[i])){
              ans.add(a[i]);
              st.add(a[i]);
          }
          i++;
      }
      while( j < b.length){
          if(!st.contains(b[j])){
              ans.add(b[j]);
              st.add(b[j]);
          }
          j++;
      }

       return ans;
    }
}
