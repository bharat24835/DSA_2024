package Sliding_Window;

public class Grumpy_BookStore_Ower {
    public static void main(String[] args) {
        int[]a ={4,10,10};
        int[]g= {1,1,0};
        int k = 2;
        System.out.println(call(a ,g,k));

    }
    public static int call(int[]a , int[]g , int k){

        int[]size = new int[2];

        int max = 0;
        int i = 0;
        int j = 0;
        int sum = 0;

        while( j<g.length){
            sum+= g[j] == 1 ? a[j] : 0;



            if(j-i+1 > k){
                sum-= g[i] == 1 ? a[i] : 0;
                i++;
            }
            if(j-i+1 == k){
                if(sum > max){
                    max = sum;
                    size[0] = i;
                    size[1] = j;
                }
            }
            j++;
        }
        System.out.println("Window Sum Size is : " + sum);


        int ans = 0;
        for(i = 0 ; i<size[0] ; i++){
            ans+= g[i] == 0 ? a[i] : 0;
        }
        for(i = size[0] ; i<=size[1]; i++){
            ans+= g[i] == 0 ? a[i] : 0;
        }
        for( i = size[1]+1 ; i <a.length ; i++){
            ans+= g[i] == 0 ? a[i]: 0 ;
        }
        return ans+max;
    }
}
