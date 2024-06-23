package Sliding_Window;

public class Get_Equal_Substrings_Within_Budget {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "cdef";
        int maxCost = 3;
        System.out.println(call(s ,t , maxCost));
    }
    public static int call(String s, String t , int maxCost){
        int ans = 0;

        int i = 0 ; // front pointer of window
        int j = 0 ; //  last pointer of window
        int cost = 0;

        while( j < s.length()){

            // what will be the cost if we take this charact
            int temp_cost = Math.abs(s.charAt(j) - t.charAt(j));

            cost +=temp_cost;

            while(cost > maxCost){
                // we goona shrink that window
                int front_cost = Math.abs(s.charAt(i) - t.charAt(i));
                cost-=front_cost;
                i++;
            }

            ans = Math.max(ans , j-i+1);
            j++;

        }
        return ans;

    }
}
