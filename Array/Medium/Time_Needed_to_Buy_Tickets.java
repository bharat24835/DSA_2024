package Array.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class Time_Needed_to_Buy_Tickets {
    public static void main(String[] args) {
        int[]a = {2,3,2};
        int k = 2;
        System.out.println(call(a , k));
    }
    public static int call(int[]a , int k){
        Queue<Integer>q = new LinkedList<>();
        int n = a.length;
        int time = 0;
        int i = 0;
        while(true){
            if(a[i%n] == 0){
                i++;
                continue;
            }
            a[i%n]--;
            time++;
            if(a[k] == 0) break;
            i++;
        }
        return time;
    }
}
