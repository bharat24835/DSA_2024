package Pointer_2;

import java.util.Arrays;

public class Bag_Of_Tokens {
    public static void main(String[] args) {
        int[]tokens = {200 ,100};
        int power = 150;
        System.out.println(call(tokens ,power));
    }
    public static int call(int[]tokens, int power){
        Arrays.sort(tokens);
        int n = tokens.length;
        int i = 0;
        int j = n-1;
        int score = 0;

        while( i <= j ){
            if(power  >= tokens[i]){
                score++;
                power-=tokens[i];
                i++;
            }
            else if (i!= j && score >=1 ){
                score--;
                power+=tokens[j];
                j--;
            }
            else{
                return score;
            }
        }
        return score;
    }
}
