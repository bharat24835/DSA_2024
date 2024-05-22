package FenWick_Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Reverse_Pairs {
    public static void main(String[] args) {
        int[]a = {1,3,2,3,1};
        System.out.println(call(a));
    }
    public static int call(int[]a){
        TreeSet<Long>ts = new TreeSet<>();
        for(int i=  0 ; i<a.length; i++){
            ts.add((long)a[i]);
            ts.add((long)2*a[i]);
        }
        // mapping each unique number to its index position
        Map<Long , Integer> map = new HashMap<>();
        int index = 0;
        for(long num:  ts){
              map.put(num , index++);
        }

        int count  =0;
        int[]bits = new int[map.size()];

        for(int i = a.length-1 ; i>=0 ; i--){
            int x = map.get((long)a[i]);
            // Query the count of elements smaller than the current number
            count+= query(x-1 , bits);
            // update the count of elemnets which are greater than current number
            update(map.get((long)2*a[i])  , 1 , bits);
        }
        return count;
    }
    public static void make_bits_array(int[]bits , int[]a){

        for(int i = 0 ; i<a.length ;i++){
            update(i , a[i] , bits);
        }
    }
    public static void update(int id, int val , int[]bits){
        id = id+1;
        while(id <= bits.length){
            bits[id-1] += val;
            id+=(id & -id);
        }
    }
    public static int query (int id , int[]bits){
        int ans = 0;
        id = id+1;
        while(id > 0){
            ans+=bits[id-1];
            id-=(id & -id);
        }
        return ans;
    }
}
