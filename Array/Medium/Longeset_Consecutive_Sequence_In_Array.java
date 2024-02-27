package Array.Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Longeset_Consecutive_Sequence_In_Array {
    public static void main(String[] args) {
        int[]a = {102,4,100,101,1,3,2,2,2,1,1};
        System.out.println(call3(a));
    }
    public static int call(int[]a){
        int ans = 0;

        for(int i =0 ; i<a.length;i++){
            int x = a[i];
            int count = 0;

            while(ls(x, a) == true){
                x++;
                count++;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
    public static boolean ls(int target, int[]a){
        for(int i =0  ; i<a.length; i++){
            if(a[i] == target) return true;
        }
        return false;
    }

    public static int call2(int[]a){
        int[]temp = Arrays.copyOf(a,a.length);

        Arrays.sort(temp);
        int max = 0;
        int count = 1;
        int min = temp[0];
        for(int i = 1 ; i<temp.length; i++){
            if(temp[i] == min) continue;

            if(temp[i] == min+1){
                count++;
            }
            else {
                count = 1;
            }
            min = temp[i];
            max = Math.max(max,count);
        }
        return max;
    }

    public static int call3(int[]a){
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i<a.length; i++){
            set.add(a[i]);
        }

        int max = 0;
        for(int i = 0 ; i<a.length; i++){
            int x = a[i];
            if(set.contains(x-1)){
                continue;
            }
            else{

                int count = 0;
                while(set.contains(x)){
                    count++;
                    x++;
                }
                max = Math.max(max,count);
            }
        }
        return max;
    }
}
