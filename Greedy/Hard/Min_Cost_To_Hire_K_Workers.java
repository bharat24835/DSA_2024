package Greedy.Hard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Min_Cost_To_Hire_K_Workers {
    public static void main(String[] args) {
        int[]quality = {4,5};
        int[]wage  = {8,14};
        int k = 2;
        System.out.println(call(quality , wage , k));
    }
    public static double call(int[]quality , int[]min_wage , int k){
        double ans = Double.MAX_VALUE;
        PriorityQueue<Pair> pq = new PriorityQueue<>(new sort());
        int n = quality.length;

       for(int i = 0 ; i<n ; i++){
           pq.offer(new Pair(quality[i] , i));
       }
        ArrayList<Pair> sorted_quality = new ArrayList<>();
       while(!pq.isEmpty()){
           sorted_quality.add(pq.poll());
       }
       for(int i = 0 ; i<n ; i++){
           System.out.println("Index is : " + sorted_quality.get(i).index + " and Quality is : " +sorted_quality.get(i).quality);
       }

       // for every index we consider  it as start
       for(int i = 0 ; i<n ; i++){
           double sum = 0;
           double ratio = (double)min_wage[i]/ (double) quality[i];
           sum+=min_wage[i];

           // sine first element is selecteed , now we can shift to tother element
           int count =1;
           int j = 0;
           while(count < k  && j < n){
               Pair worker = sorted_quality.get(j);
               int his_quality  = worker.quality;
               int his_index = worker.index;

               if(worker.index != i){
                   double calculated_wages = ratio* worker.quality;
                   if(calculated_wages >= min_wage[worker.index]){
                       sum+=calculated_wages;
                       count++;
                   }
               }
               j++;
           }
           if(count == k)
           ans = Math.min(ans, sum);
       }


        return ans;

    }


}
class  Pair{
    int quality;
    int index;
    Pair(int a, int b){
        this.quality = a;
        this.index = b;
    }
}
class  sort implements Comparator<Pair>{
    @Override
    public int compare(Pair a, Pair b){
        return a.quality -b.quality;
    }
}