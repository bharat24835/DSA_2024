package Array.Medium;

public class Stock_Buy_And_Sell {
    public static void main(String[] args) {
            int a[] = {7,1,5,3,6,4};


            int maxP =  0;
            int minP = Integer.MAX_VALUE;

                    for(int i = 0 ;i <a.length; i++){
                         minP = Math.min(minP, a[i]);

                         maxP  = Math.max(maxP, a[i] - minP);
                    }
        System.out.println("Correct Answer is :- " + maxP );
    }
}
