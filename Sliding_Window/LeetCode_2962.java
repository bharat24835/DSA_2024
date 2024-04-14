package Sliding_Window;

public class LeetCode_2962 {
    public static void main(String[] args) {
        int k = 2;
        int[]a ={1,3,2,3,3};
        System.out.println(call1(a , k));
        System.out.println(call2(a , k));

    }

    public static int call2(int[]a , int k){
        int i = 0;
        int j = 0;
        int n = a.length;
        int count = 0;
        int maxElement = find_max(a);
        int maxFreq = 0;

        while(j < n){
            if(a[j] == maxElement) maxFreq++;

            while(i <=j && maxFreq >= k){
                if(a[i] == maxElement)maxFreq--;
                i++;
            }
            if(maxFreq < k){
                count+=(j-i+1);
            }
            j++;
        }
        int total_subarray = find_total_subarray(a);

        return total_subarray - count;

    }

    public  static  int call1(int[]a , int k ){
        int max = find_max(a);
        int n = a.length;
        int count  =0;

        for(int i = 0 ;i<n ; i++ ){
            int max_freq =0;
            for(int j = i ; j<n ; j++){
                if(a[j] == max){
                    max_freq++;
                }
                if(max_freq < k){
                    count++;
                }

            }
        }
        int total_subarray = find_total_subarray(a);

        return total_subarray - count;
    }
    public static int find_max(int[]a){
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i<a.length ; i++){
            max = Math.max(max , a[i]);
        }
        return max;
    }

    public static int find_total_subarray(int[]a){
        int n = a.length;
        return (n*(n+1))/2;
    }
}
