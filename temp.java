public class temp {
    public static void main(String[] args) {
        int[]a = {1,0,1,0,1};
        int k  =2;
        System.out.println(numSubarraysWithSum(a,k));
    }
    public static int numSubarraysWithSum(int[] a, int k) {
        int count = 0;
        int i =0;
        int j =0;
        int sum = 0;
        int count_zeros = 0;

        while(  j < a.length){
            sum+=a[j];



            while( i <a.length && (a[i] == 0 || sum > k)){
                if(a[i] == 0) count_zeros++;
                else  count_zeros = 0;
                sum-=a[i];
                i++;
            }
            if(sum == k) count+= 1 + count_zeros;

            j++;
        }

        return count;
    }
}
