package Contest_LeetCode.April_14;

public class Practise_Bits {
    public static void main(String[] args) {
        int[]a = {5,2};
        int k = 7;
        System.out.println(call(a , k));
    }
    public static long call(int[]a , int k){
        // find min =
        int min = find_min(a);

         long ans= 0;
        int count = 0;
        while(k >0){

            int ones = k&1;
            if(ones == 1)
            ans+= min*(1<<count);
            k = k>>1;
            count++;
        }
        return ans;
    }
    public static int find_min(int[]a){
        int min = Integer.MAX_VALUE;
        for(int i= 0 ; i<a.length; i++){
            min = Math.min(min , a[i]);
        }
        return min;
    }
}
