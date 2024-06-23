package Binary_Search.Search_On_Answer;

public class Koko_Eating_Banana {
    public static void main(String[] args) {
        int[]a = {3,6,7,11};
        int h = 8;
        System.out.println(call(a , h));
    }
    public static int call(int []a , int h){

        int min  =  1; // min possible eating speed
        int max  = -1; // max possible eating speed

        for(int i = 0 ; i<a.length;i++){
            max = Math.max(max , a[i]);
        }

        int ans = -1;

        while( min <= max){
            int mid = min + (max - min)/2;

            if(call1(mid , a, h)){
                ans  = mid;
                // there are chance that , we can have more less number
                max = mid-1;

            }
            else{
                min = mid+1;
            }
        }
        return ans;
    }
    public static boolean call1(int speed , int[]a , int h){
        int count = 0;
        int sum =0;
        for(int i = 0 ; i<a.length; i++){
            count +=  a[i]/speed;
            // agar voh divide nhi ho rha that , then it will increast one bit
            if(a[i] % speed > 0){
                count++;
            }
        }

        return count <= h;

    }
}
