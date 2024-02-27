package Array.Medium;

import java.util.ArrayList;
import java.util.Arrays;

public class Rearrange_ELment_By_Sign {
    public static void main(String[] args) {
        int[] a= {3,1,-2,-5,2,-4,-1,-3,-3};
        call(a);
        System.out.println(Arrays.toString(a));
     //   System.out.println(Arrays.toString(call1(a)));
    }
    public static void call(int[]a){
        ArrayList<Integer>p = new ArrayList();
        ArrayList<Integer>n = new ArrayList();

        for(int i = 0 ; i <a.length; i++){
            if(a[i] > 0) p.add(a[i]);
            else n.add(a[i]);
        }
        int k = 0 ;
        for(int i = 0 ; i<Math.max(p.size(),n.size()); i++){
            if( i < p.size())
            a[k++] = p.get(i);
            if(i < n.size())
            a[k++] = n.get(i);

        }
    }

    public static int[] call1(int[]a){
    int p = 0;
    int n = 1;
    int[]temp  = new int[a.length];
    for(int i = 0 ; i<a.length; i++){
        if(a[i] > 0 ){
            temp[p] = a[i];
            p+=2;
        }
        else{
            temp[n] = a[i];
            n+=2;
        }
    }
    return temp;

    }

}
