package Array.Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Set_Matrix_Zero {
    public static void main(String[] args) {
        int[][]a = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(a);
        for(int i =0 ; i<a.length; i++){
            System.out.println(Arrays.toString(a[i]));
        }
    }
    public static void setZeroes(int[][] a) {
        Set<String> set = new HashSet<>();
        int n = a.length;
        int m = a[0].length;

        // traverse the array and fill the set with zeros
        for(int i =0 ; i<n ; i++){
            for(int j =0; j<m ; j++){
                if(a[i][j] == 0){
                    String temp = Integer.toString(i)+ Integer.toString(j);
                    set.add(temp);
                }
            }
        }



        // now again traversing the array

        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                String temp = Integer.toString(i)+ Integer.toString(j);
                if(a[i][j] == 0 && set.contains(temp)){
                    setArray(a, i,j);
                    set.remove(temp);
                }



            }
        }
    }
    public static void setArray(int[][]a, int x, int y){
        int n = a.length;
        int m = a[0].length;

        // setting xth row 0 and yth column 0
        for(int i =0 ; i<m ; i++){
            a[x][i] = 0;
        }
        for(int i =0 ; i<n ; i++){
            a[i][y] = 0;
        }
    }
}
