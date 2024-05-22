package Heaps.Medium;

import java.nio.charset.IllegalCharsetNameException;
import java.util.*;

public class Kth_Smallest_Fraction {
    public static void main(String[] args) {
        int[]a ={1,2,3,5};
        int k = 3;
       int[]ans = call(a , k);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
    public  static int[] call(int[]a , int k){

        PriorityQueue<Double>pq = new PriorityQueue<>(Collections.reverseOrder());
        Map<Double , ArrayList<Integer>> map = new HashMap<>();

        for(int i = 0 ; i<a.length-1 ; i++){
            for(int j =i+1 ; j<a.length ; j++){
                double ans =  (double)a[i]/ (double) a[j];
                ArrayList<Integer>temp = new ArrayList<>();
                temp.add(i);
                temp.add(j);
                map.put(ans, temp );
                pq.offer(ans);

                if(pq.size() > k){
                    pq.poll();
                }
            }
        }
        double temp = pq.poll();
        int[]ans = new int[2];
        ArrayList<Integer> t  = map.get(temp);
        ans[0] = a[t.get(0)];
        ans[1] = a[t.get(1)];
        return ans;
    }
    public int[] call1(int[]arr , int k){

        int n = arr.length;
        PriorityQueue<double[]> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a[0]));

        for (int i = 0; i < n; i++)
            pq.offer(new double[]{1.0 * arr[i] / arr[n - 1], (double) i, (double) (n - 1)});

        int smallest = 1;

        while (smallest < k) {
            double[] vec = pq.poll();

            int i = (int) vec[1];
            int j = (int) vec[2] - 1;

            pq.offer(new double[]{1.0 * arr[i] / arr[j], (double) i, (double) j});
            smallest++;
        }

        double[] vec = pq.peek();
        int i = (int) vec[1];
        int j = (int) vec[2];
        return new int[]{arr[i], arr[j]};
    }

}
