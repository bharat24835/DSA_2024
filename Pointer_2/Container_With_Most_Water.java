package Pointer_2;

public class Container_With_Most_Water {
    public static void main(String[] args) {
        int[]a = {1,8,6,2,5,4,8,3,7};
        System.out.println(call(a));
    }
    public static int call(int[]a){
        int n = a.length;
        int max = 0;

        int left = 0;
        int right = n-1;

        while(left <= right){
            if(a[left] <= a[right]){
                max = Math.max(max, a[left]*(right-left) );
                left++;
            }
            else{
                max = Math.max(max, a[right]*(right-left));
                right--;
            }

        }
        return max;

    }
}
