package POD_GFG;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Find_Missing_Number {
    public static void main(String[] args) {
        int[]a = {1,2,3,4,5,10};
        int[]b = {2,3,1,0,5};

        System.out.println(call(a , b));
    }
    public static ArrayList<Integer>call(int[]a, int []b){
        ArrayList<Integer>ans = new ArrayList<>();
        Set<Integer>set = new HashSet<>();
        for(int i= 0 ;i<b.length ; i++){
            set.add(b[i]);
        }

        for(int i= 0  ; i<a.length ; i++){
            if(!set.contains(a[i])){
                ans.add(a[i]);
            }

        }
        return ans;
    }
}
