package Problem_Of_Day;

import java.util.ArrayList;
import java.util.List;

public class Sequenctial_Digits {
    public static int l;
    public static int h;
    public static void main(String[] args) {
        int low = 1000;
        int high = 13000;
        l = low;
        h = high;
        System.out.println(call(low, high));
      //  System.out.println(get(8,3));
    }
    public static List<Integer> call(int low , int high){
        List<Integer>ans = new ArrayList<>();
        call1(ans);
        return ans;


    }
    public static void call1(List<Integer>ans){

        int mind = (int) Math.log10(l)+1;
        int maxd = (int) Math.log10(h)+1;


        for(int d = mind; d<=maxd; d++ ){

            for(int i =1; i <= 10 - d; i++){
                // i represent stating number
                int num = get(i, d);
                if(num >= l && num<=h){
                    ans.add(num);
                }
            }
        }
    }
    public static int get(int num , int d){
        int prev = num;
        if(d == 1) return num;
        int ans = 0;
        while(d > 1){
            ans = num*10+(prev+1);
            num = ans;
            prev = prev+1;
           d--;

        }
        return ans;
    }
}
