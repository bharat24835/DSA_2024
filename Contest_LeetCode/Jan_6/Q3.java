package Contest_LeetCode.Jan_6;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Q3 {
    public static int maxv;
    public static int minv;
    public static void main(String[] args) {
        int x = 54;
        int y=  2;

        System.out.println(call(x,y));
    }
    public static int call(int x, int y){
        if(y>=x) return y-x;

        Queue<Integer>q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.offer(x);
        int count = 0 ;

        while(!q.isEmpty()){
            int size= q.size();

            for(int i = 0 ; i<size; i++){

                int num = q.poll();
                if(num == y) return count;

                // increment 1
                if(!set.contains(num+1)) {
                    q.offer(num+1);
                    set.add(num+1);
                }

                // decremetn 1
                if(!set.contains(num-1)){
                    q.offer(num-1);
                    set.add(num-1);
                }

                // div by 5
                if(num % 5 == 0 && !set.contains(num / 5 )) {
                    q.offer(num/5);
                    set.add(num/5);
                }

                // div by 11
                if(num % 11 == 0 && !set.contains(num / 11 )) {
                    q.offer(num/11);
                    set.add(num/11);
                }

            }
            count++;
        }
        return count;


    }
}
