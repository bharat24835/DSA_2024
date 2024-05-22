package DP.Practise;

public class Practise1 {
    public static void main(String[] args) {
        int[]fc = {1,2};
        int[]bc = {2,1};
        int f  = 1;
        int b = 1;
        System.out.println(call( 0 , f , b , fc, bc));

    }
    public static int call(int i , int f, int b , int[]fc , int[]bc){
        if(i == fc.length)return 0;

        // every index we have 2 option either we choose this as front end or backend
        int frontend = (int)1e7;
        int backend = (int)1e7;

        if(f > 0){
            frontend = fc[i] + call(i+1 , f-1 , b, fc, bc);
        }
        if(b > 0){
            backend = bc[i] + call(i+1 , f, b-1 , fc, bc);
        }

        return Math.min(frontend , backend);
    }
}
