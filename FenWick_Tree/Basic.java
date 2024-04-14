package FenWick_Tree;

import java.util.Arrays;

public class Basic {
    public static void main(String[] args) {
        int[]a = {5,2,9,-3,5,20,10,-7};
        int[]bits = new int[a.length+1];
        make_bits_array(bits ,a );
        System.out.println(Arrays.toString(bits));
        System.out.println(query( 2 , bits));
        System.out.println(query( 5 , bits));
        System.out.println(query(5 ,bits)  - query(2,bits));
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
