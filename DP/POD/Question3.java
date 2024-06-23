package DP.POD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question3 {
    public static void main(String[] args) {
        int[][] operations = {

                {1, 1, 1}
        };
List<Boolean>result  = solution(operations);
        System.out.println(result);

    }
    public static List<Boolean> solution(int[][] operations) {
        List<Boolean> results = new ArrayList<>();
        List<int[]> rectangles = new ArrayList<>();

        for (int[] operation : operations) {
            if (operation[0] == 0) { // Create and save a rectangle
                rectangles.add(new int[]{operation[1], operation[2]});
            } else if (operation[0] == 1) { // Check if box fits inside saved rectangles
                boolean fits = true;
                int boxA = operation[1];
                int boxB = operation[2];
                for (int[] rectangle : rectangles) {
                    int a = rectangle[0];
                    int b = rectangle[1];
                    if ((boxA >= a && boxB >= b) || (boxA >= b && boxB >= a)) {
                        fits = false;
                        break;
                    }
                }
                results.add(fits);
            }
        }


        Boolean[]ans = new Boolean[results.size()];
        for(int  i = 0 ; i<ans.length ; i++){
            ans[i] = results.get(i);

        }
//        System.out.println(Arrays.toString(ans));
//        return ans;
        return results;
  }
}

