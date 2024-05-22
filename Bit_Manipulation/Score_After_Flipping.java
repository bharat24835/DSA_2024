package Bit_Manipulation;

public class Score_After_Flipping {
    public static void main(String[] args) {
        int[][]a ={{0,0,1,1} , {1,0,1,0} ,{1,1,0,0}};
        System.out.println(call(a));
    }
    public static int call(int[][]a){

        int ans = 0;

        int n = a.length;
        int m = a[0].length;

        // first columns should always be 1

        ans+= n*Math.pow(2, m-0-1);

        for(int j = 1 ; j<m ; j++){

            int count_Same_Bits = 0;

            for(int i = 0 ; i<n ; i++){
                if(a[i][j] == a[i][0])count_Same_Bits++;
            }

            int count_Ones = count_Same_Bits;
            int count_Zeros= n - count_Ones;
            int max = Math.max(count_Zeros , count_Ones);

            ans+= max*Math.pow(2, m-j-1);

        }
        return ans;

    }
}
