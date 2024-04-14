package String.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Min_Deletion_To_Make_String_K_Special {
    public static void main(String[] args) {
        String word = "dabdcbdcdcd";
        int k = 2;
        System.out.println(call(word , k));
    }
    public static int call(String word , int k ){

        int[]freq = new int[26];
        for(int i = 0 ; i<word.length(); i++){
            int temp = (int)word.charAt(i)-'a';
            freq[temp]++;
        }
        Arrays.sort(freq);


        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i<26 ; i++){
            if(freq[i]!= 0){
                list.add(freq[i]);
            }
        }
        int ans = Integer.MAX_VALUE;
        int min_Deleted = 0;

        for(int i = 0 ; i<list.size(); i++){
            int count = 0;
            for(int j = list.size()-1 ; j>i  ; j--){
               if(list.get(j) - list.get(i) > k){
                   int del = list.get(j) - list.get(i) - k;
                   count+=del;
               }
            }
            ans = Math.min(ans , count+ min_Deleted);
            min_Deleted+=list.get(i);
        }
        return ans;


    }
}
