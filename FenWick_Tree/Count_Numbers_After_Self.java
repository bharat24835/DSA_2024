package FenWick_Tree;

import java.util.*;

public class Count_Numbers_After_Self {
    public static void main(String[] args) {
        int[]a = {5,2,6,1};
        System.out.println(call(a));
    }
    public static List<Integer> call(int[]a){
        List<Integer>ans = new ArrayList<>();
        for(int i = 0 ; i<a.length ; i++){
            ans.add(0);
        }
        List<Pair> list = new ArrayList<>();

        for(int i = 0 ; i<a.length ; i++){
            // storing the (element , index)pair
            list.add(new Pair(a[i] , i));
        }
        Queue<Pair>q  = new LinkedList<>();
      //  Collections.sort(q , new Comparator<>());

        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.element - o2.element;
            }
        });

        int[]bits = new int[a.length];
        for(int i = 0 ; i< list.size() ; i++){
            Pair temp = list.get(i);
            int index = temp.index;
            int count = query(a.length-1 , bits) - query(index , bits);
            // update bits
            update(index , 1, bits);
            ans.set(index , count);
        }
        return ans;
    }

    public static void update (int id , int val , int[]bits){
        id++;
        while ( id <= bits.length){
            bits[id-1]+=val;
            id+=(id & -id);
        }
        return;
    }
    public static int query(int id , int[]bits){
        id++;
        int ans = 0;
        while(id > 0 ){
            ans+=bits[id-1];
            id -= (id & -id);
        }
        return ans;
    }
    public static class Pair{
        int element;
        int index;
        Pair(int a, int b){
            this.element = a;
            this.index = b;
        }
    }
}

