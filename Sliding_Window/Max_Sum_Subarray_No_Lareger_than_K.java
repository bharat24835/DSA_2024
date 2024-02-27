package Sliding_Window;

public class Max_Sum_Subarray_No_Lareger_than_K {
    public static void main(String[] args) {
        int[]a = {5,-2, 6,3,-5};
        int  k = 15;
        System.out.println(call(k , a));
    }
    public static int call(int k , int[]a){
        // Prefix version also Availab
        // try to do this
        int sum = 0 ;
        int max = 0;
        int i = 0;
        int j = 0;

        while(j <a.length){
            sum+=a[j];


            while(sum > k || a[i] < 0){
                sum-=a[i];
                i++;
             //   max = Math.max(sum, max);
            }

            max = Math.max(max, sum);
            j++;
        }
        return max;
    }
}
