package Problem_Of_Day;

public class Cheery_PickUp_2 {
    public static void main(String[] args) {
        int[][]a = {{3,1,1},{2,5,1},{1,5,5}, {2,1,1}};
        System.out.println(call(0,0,a[0].length-1,a));
    }
    public static int call(int i , int j1 , int j2 , int[][]a){
        if(i == a.length-1){
            if(j1 == j2)return a[i][j1];
            else return a[i][j1] + a[i][j2];
        }
        int r1 = 0;
        int r2 = 0;
        int ans =  0;
        int sum = 0;
        // down moves
        sum = j1==j2?a[i][j1]:a[i][j1] + a[i][j2];

       // r1 modes down
        for(int j  = -1 ; j<=1; j++){
            if(j2+j>=0 && j2+j <a[0].length )
            ans =Math.max(ans, sum + call(i+1,j1,j2+j,a));
        }
        // r1 moves down left
        if(j1-1 >=0){
            for(int j = -1 ; j<=1 ; j++){
                if(j2+j>=0 && j2+j <a[0].length )
                ans =Math.max(ans, sum + call(i+1,j1-1,j2+j,a));
            }
        }

        // r1 moves down right
        if(j1+1 <a[0].length){
            for(int j = -1 ; j<=1 ; j++){
                if(j2+j>=0 && j2+j <a[0].length )
                ans =Math.max(ans, sum + call(i+1,j1+1,j2+j,a));
            }
        }

        return ans;


    }
}
