package Contest_LeetCode.May_5;

public class Question_4 {
    public static void main(String[] args) {
        int[]a = {2,3,3,3,5};
        int c1 = 2;
        int c2 = 1;
        System.out.println(call(  c1 , c2 ,a));
    }
    public static int call(int cost1 , int cost2 , int[]a){
        int max = find_max(a);
        long sum = 0;
        for(int i = 0 ; i<a.length ; i++){
            a[i] = max-a[i];
            sum+=a[i];
        }
        System.out.println("Sum is :- " + sum );

        int ans = call(0 , cost1  ,cost2 ,a );
        return ans;


    }
    public static int call(int i , int cost1 , int cost2 , int[]a){
        if(i == a.length ) return 0;
        if(a[i] == 0 ) return call(i+1, cost1, cost2 , a);

        int op1 = Integer.MAX_VALUE;
        int op2 = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;

        // decreasing the given index by 1 , and if a[i] become 0 move ahead
        a[i]--;
        if(a[i]== 0){
            op1 = cost1+ call(i+1 , cost1, cost2 , a);
        }
        else op1 = cost1 +call(i , cost1 , cost2, a);
        // backtraking bro
        a[i]++;

        // decreasing the given index by and chose another index to decrease it
        a[i]--;
        // choose index
        int min = Integer.MAX_VALUE;
        for(int j =i +1 ; j <a.length ; j++ ){

            if(a[j] != 0){
                a[j]--;
                if(a[i]== 0){
                    op2 = cost2+ call(i+1 , cost1, cost2 , a);
                }
                else op2 = cost2 +call(i , cost1 , cost2, a);
                a[j]++;
                min = Math.min(min , op2);
            }

        }
        return Math.min(op1 ,min );





    }
    public static int find_max(int[]a){
        int max = a[0];
        for(int i = 1 ; i<a.length; i++){
            max = Math.max(max , a[i]);
        }
        return max;
    }

}
