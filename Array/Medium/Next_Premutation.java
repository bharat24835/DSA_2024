package Array.Medium;

import java.util.Arrays;

public class Next_Premutation {
    public static void main(String[] args) {
        int[]a = {3,2,3,1,4,5,1};
        call(a);
        System.out.println(Arrays.toString(a));
    }
    public static void call(int[]a){
        // Next Permuation

        // find Break point
        int index = -1;
        for(int i = a.length-2 ; i>=0 ; i-- ){
            if(a[i] < a[i+1]){
                index   = i;
                break;
            }
        }
        if(index == -1)
            reverseArrayBetweenIndices(a, 0, a.length-1) ;
        else{
            int temp = -1;

            int min =  Integer.MAX_VALUE;
            for(int i =index ;i<a.length ; i++){
                if(a[i] > a[index] && a[i] <= min){
                    min = a[i];
                    temp = i;
                }
            }

            int q = a[index];
            a[index] = a[temp];
            a[temp]  =q;

            reverseArrayBetweenIndices(a, index+1, a.length-1) ;

        }
    }
    public static void reverseArrayBetweenIndices(int[] array, int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex >= array.length || startIndex >= endIndex) {

            return;
        }

        while (startIndex < endIndex) {
            // Swap elements at startIndex and endIndex
            int temp = array[startIndex];
            array[startIndex] = array[endIndex];
            array[endIndex] = temp;

            // Move indices towards the center
            startIndex++;
            endIndex--;
        }
    }
}
