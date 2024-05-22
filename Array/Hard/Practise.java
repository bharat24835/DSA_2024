package Array.Hard;

import java.util.ArrayList;
import java.util.List;

public class Practise {
    public static void main(String[] args) {
        int[]a = {5,2,6,1};
        List<Pair> temp = new ArrayList<>();
        for(int i = 0 ; i<a.length ; i++){
            Pair p = new Pair(a[i] , i);
            temp.add(p);
        }
        System.out.println(call(temp));
    }
    public static List<Integer> call(List<Pair>a){
        List<Integer>ans = new ArrayList<>();
        //  int[]index = new int[a.length];
        int[]count = new int[a.size()];


        mergeSort(a, count , 0 , a.size()-1);
        for(int i = 0 ; i<a.size() ; i++){
            ans.add(count[i]);
        }
        return ans;

    }
    public static void mergeSort(List<Pair>a , int[]count , int start , int end){
        if(start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(a,  count, start, mid);
            mergeSort(a, count, mid + 1, end);

            // merge kar bhai
            merge(a,  count, start, mid, end);
        }
    }
    public static void merge(List<Pair>a  , int[]count , int start , int mid , int end){
        //Pair[]temp = new Pair[end - start+1];
        List<Pair> temp = new ArrayList<>();
        for(int q = 0 ; q <= end- start+1 ; q++){
            temp.add(new Pair(0,0));
        }

        int i = 0;
        int j = mid+1;
        int k = 0;

        while( i <= mid && j<=end){
            if(a.get(i).num  <= a.get(j).num ){
                temp.set(k , a.get(j)) ;
                k++;
                j++;
            }
            else{
                // main part yahi hai
                count[a.get(i).index] += end - j+1;
                temp.set(k  , a.get(i));
                k++;
                i++;
            }
        }

        while( i <= mid){
            temp.set(k++ , a.get(i++));
            // temp[k++] = a[i++];
        }
        while( j <= end){
            temp.set(k++ , a.get(j++));
            // temp[k++] = a[j++];
        }

        for (int x = start ; x<= end ; x++){
            a.set(x , temp.get(x- start));
            //   a[x].num = temp[x - start].num;
            // a[x].index = temp[x - start].index;
        }

    }



    public static class  Pair{
        int num;
        int index;
        Pair(int a, int b){
            this.num  = a;
            this.index  =b;
        }
    }
}
