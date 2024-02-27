package Problem_Of_Day;

public class Building_You_Can_Reach {
    public static void main(String[] args) {
        int[]a = {1,5,1,2,3,4,10000};
        int bricks = 4;
        int ladder = 1;
        System.out.println(call(a, bricks,ladder));
    }
    public static int call(int[]a, int bricks, int ladder){
        int i = 0 ;
        int n = a.length;
       // int count = 0 ;
        while( i < n-1){
            if(a[i] >= a[i+1] ){
                i++;
                continue;
            }
            else if(a[i] < a[i+1]){
                int diff = a[i+1] -a[i];

                // First we use bricks
                if(bricks >= diff){
                    bricks-=diff;
                    i++;
                }
                else if(ladder != 0 ){
                    ladder--;
                    i++;
                }
                else{
                    return i;
                }


            }
        }
        return n-1;
    }
}
