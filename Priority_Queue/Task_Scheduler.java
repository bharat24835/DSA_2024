package Priority_Queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Task_Scheduler {
    public static void main(String[] args) {
      //  char[] tasks = {'A' , 'A' , 'A' , 'A' , 'A', 'A' , 'B' , 'B', 'C' , 'D'};
        //char[] tasks = {'A' ,'A','A','B','B','B'};
        char[] tasks = {'A' ,'A','C','B','D','B'};
        int k =3;
        System.out.println(call(tasks , k));
    }
    public static int call(char []tasks , int k){
        int[]temp  = new int[26];

        for(int i = 0 ; i<tasks.length ; i++){
            int index = (int)(tasks[i] - 'A');
            temp[index]++;
        }

        PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0 ; i<26 ; i++ ){
            if(temp[i] != 0){
                pq.offer(temp[i]);
            }
        }

        int time = 0;

        while(!pq.isEmpty()){
            int max_Freq = pq.poll();
            time++;
            List<Integer> temp2 = new ArrayList<>();

            // rest for k Times
            for(int i =1 ; i<=k ; i++){
                if(!pq.isEmpty()){
                    int freq = pq.poll();
                    time++;
                    if(freq-1 != 0){
                        temp2.add(freq-1);
                    }
                }
                else if(max_Freq- 1 != 0){
                    time++;
                }
                else{
                    return time;
                }
            }

            if(max_Freq-1!= 0){
                pq.offer(max_Freq-1);
            }
            for(int i = 0 ; i<temp2.size() ; i++){
                pq.offer(temp2.get(i));
            }
        }
        return time;
    }
}
