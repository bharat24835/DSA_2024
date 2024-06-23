package Binary_Search.Search_On_Answer;

public class Minimum_Number_of_Days_to_Make_m_Bouquets {
    public static void main(String[] args) {
        int[]a = {7,7,7,7,12,7,7};
        int m = 2;
        int k = 3;
        System.out.println(call(a , m ,k));
    }
    public static int call(int[]a , int m , int k){
        int minD = Integer.MAX_VALUE;
        int maxD = Integer.MIN_VALUE;

        for(int i = 0 ; i<a.length ; i++){
            minD = Math.min(minD , a[i]);
            maxD = Math.max(maxD , a[i]);
        }

        int ans = -1 ;

        while( minD <= maxD){

            int mid_Days = minD + (maxD-minD)/2;

            if(call1(mid_Days  , m , k , a)){
                ans = mid_Days;
                maxD = mid_Days-1;
            }
            else{
                minD = mid_Days+1;
            }
        }
        return ans;
    }
    public static boolean call1(int bloom_days , int m , int k , int[]a){
        // we need to check
        // wheather we can select m bouquest of having k adjacenet flowers
        int prev = -1;
        int temp_k = k;

        for(int i = 0 ; i<a.length ; i++){
            int days = a[i];
            if(days <= bloom_days){
                if(prev == -1){
                    prev = i;
                }
            }
            else{
                prev = -1;
            }
            if(prev!= -1 &&   (i - prev + 1) == k){
                prev = -1;
                m--;
                if(m == 0) return true;
            }
        }
        return false;
    }
}
