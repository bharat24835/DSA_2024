package Contest_LeetCode.Jan_6;

import java.util.HashSet;
import java.util.Set;

public class Smallest_Missing_Integer_Greater_than_Sequenctioal_Sum {
    public static void main(String[] args) {
        int[]a = {14,9,6,9,7,9,10,4,9,9,4,4};
        System.out.println(call(a));
    }
    public static int call(int[]a){
        // i - start of subarray
        // j - end of subarray
        int max   = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for(int i  =0 ; i<a.length; i++){
            set.add(a[i]);
        }


        for(int i =0 ; i<a.length; i++){


                int sum  = 0 ;
                int prev= 0;
                for(int k = 0 ; k<=i ; k++){
                    if(prev != 0 && a[k]!= prev+1) break;
                    sum+=a[k];
                    prev = a[k];

                }
             int ans = sum ;
                while(true){
                    if(set.contains(sum))sum++;
                    else{
                        ans = sum;
                        break;
                    }
                }
                max = Math.max(sum, max);




        }
        return max;
    }
}
