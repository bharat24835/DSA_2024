package Array.Medium;

public class Kadanes_Algo_Print_SubArray {
    public static void main(String[] args) {
        int[]a = {-2,1,-3,4,-1,2,1,-5,4};
        int[]temp = new int[2];
        // 0th index for start of array
        // 1st index for end of array

        System.out.println(call(a, temp));
        for(int i = temp[0] ; i<=temp[1]; i++){
            System.out.print(a[i] + ",");
        }
    }
    public static int call(int[]a, int []temp){


       int max  = Integer.MIN_VALUE;
       int sum = 0 ;
       temp[0] = 0;
       for(int i =0 ;  i<a.length; i++){
           sum+=a[i];

           if(sum > max){
               max = sum;
               temp[1] = i;
           }
           if(sum < 0 ){
               temp[0] = i+1;
               sum = 0;
           }

       }
       return max;
    }
}
