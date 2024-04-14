package Pointer_2;

import java.util.Arrays;
import java.util.Stack;

public class Tapping_Rain_Water {
    public static void main(String[] args) {
        int []heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(call1(heights));
        System.out.println(call2(heights));
    }
    public static int call1(int[]heights){
        // Next Greater or Equal
        // Previous Greater or Equal
        int n = heights.length;
        int[]pge = findPreviousGreaterIndexes(heights);
        int[]nge = findNextGreaterIndex(heights);
        System.out.println(Arrays.toString(pge));
        System.out.println(Arrays.toString(nge));

        int ans = 0;
        for(int i=  0 ; i<n ; i++){
            ans+=Math.min(pge[i], nge[i]) - heights[i];
        }

        return ans;
    }
    public static int[]findPreviousGreaterIndexes(int[]heights){
        int n = heights.length;
        int[]temp = new int[heights.length];
        int max = 0;

        for(int i= 0 ; i<n ; i++){
            max = Math.max(max, heights[i]);
            temp[i] = max;
        }
        return temp;

    }
    public static int[]findNextGreaterIndex(int[]heights){
        int n = heights.length;
        int[]temp = new int[n];

        int max = 0;
        for(int i = n-1; i>=0 ; i--){
            max = Math.max(max, heights[i]);
            temp[i] = max;
        }
        return temp;

    }
    public static int call2(int[]heights){
        int n = heights.length;
        int ans  = 0 ;

        int maxLeft = 0;
        int maxRight = 0 ;
        int left = 0;
        int right = n-1;

        while(left <= right){

            if(heights[left] <= heights[right] ){
                // there might be the chances ki LEFT pointer par pani store ko sake
                // but there is one condition that ,
                // water tabhi store hoga jab , left pointer k peeche usee bda block ho
                if(heights[left] >= maxLeft){
                    maxLeft = heights[left];
                }
                else{
                    // pani store hoga at Left Pointer , because uskk peeche(left pointer k peeche) ,
                    // ek bda block hai
                    ans+=maxLeft-heights[left];

                    // Q- Why we write upar wali line
                    // bhai right pointer toh bda hai
                    // min toh left pinter hai , usk hisab se pani store hoga
                }
                left++;
            }
            else{
                // now we look at RIGHT poiner
                if(heights[right] >= maxRight){
                    maxRight = heights[right];
                }
                else{
                    ans+=maxRight - heights[right];
                }
                right--;
            }

        }
        return ans;
    }
}
