package Sliding_Window;

public class Max_Points_Obtained_From_Cards {
    public static void main(String[] args) {
        int[]a = {1,2,3,4,5,6,1};
        int k = 3;
        System.out.println(call(a, k));
    }
    public static int call(int[]a, int k){

        int n = a.length;
        int new_k = n-k;

        int min = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int sum = 0;

        while( j < n){
            sum+=a[j];

            if(j-i +1  ==  new_k ){
                min = Math.min(min,sum);
                sum-=a[i];
                i++;
            }
            j++;

        }
        int total = 0;

        for( i = 0; i<n ; i++){
            total+=a[i];
        }
        return new_k == 0 ? total:   total - min;
    }

}
