package Greedy.Questions;

import java.util.Collections;
import java.util.PriorityQueue;

public class Furthest_Building_You_Can_Reach {
    public static void main(String[] args) {
        int[]a = {4,2,7,6,9,14,12};
        int bricks  =5;
        int ladder = 1;
        System.out.println(call(0,bricks, ladder, a));
        System.out.println(call1(bricks,ladder,a));
    }
    public static int call(int i , int bricks, int ladder, int[]a){
        if( i== a.length-1) return a.length-1;
        int ans = 0;
        if(a[i] >= a[i+1]){
            int temp = call(i+1, bricks,ladder, a);
            ans = Math.max(ans, temp);
        }
        else{
            int b = 0 ;
            int l = 0 ;
            int diff = a[i+1] - a[i];
            if(bricks < diff && ladder == 0 )return i;
            if(diff <= bricks){
                b  = call(i+1, bricks-diff, ladder,a);
            }
            if(ladder!= 0)
             l =call(i+1,bricks,ladder-1, a);
            ans = Math.max(ans , Math.max(l,b));


        }

        return ans;

    }

    public static int call1(int bricks, int ladder, int[]a){
        PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());
        int max  =0 ;

       for(int i = 0  ;i<a.length-1 ; i++){
           if(a[i+1] > a[i]){
              int diff = a[i+1] - a[i];

              // if we are having requrie bricks , then we will use brick
               if(diff <= bricks){
                   pq.offer(diff);
                   bricks = bricks - diff;
               }
               else if (ladder > 0  ){
                   // we are in condition that we have to use ladder
                   // then we will look into our Purane Karma ,

                   // kya maine Pehlai max bricks use kiye hai diff se
                   if(!pq.isEmpty() && diff >= pq.peek() ){
                       // bro no purane operation mia kahin , itne diff se zyda brick used nhi hia
                       // mai toh ladder hi use karoonga
                       ladder = ladder-1;
                   }
                   else if(!pq.isEmpty()) {
                       int past_Brick_used = pq.poll();
                       bricks = bricks + past_Brick_used;
                       ladder = ladder - 1;

                       // perform operation over bricks
                       bricks = bricks - diff;
                       pq.offer(diff);

                   }
                   else{
                       ladder = ladder-1;
                   }
               }
               else{
                   return i;
               }

           }

       }

        return a.length-1;
    }
}
