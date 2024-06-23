package Array.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question_2 {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4};
        int[] result = solution(numbers);
        System.out.println(Arrays.toString(result)); // Output: [5, 9, 2, 7, 6]
    }
    public static int[] solution(int[] numbers) {
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();

        if (numbers.length == 0) {
            return new int[]{}; // if the input array is empty, return an empty list
        }

        first.add(numbers[0]);
        if (numbers.length > 1) {
            second.add(numbers[1]);
        }

        for (int i = 2; i < numbers.length; i++) {
            int num = numbers[i];
            int countFirst = 0;
            int countSecond = 0;

            for (int x : first) {
                if (x > num) {
                    countFirst++;
                }
            }

            for (int x : second) {
                if (x > num) {
                    countSecond++;
                }
            }

            if (countFirst > countSecond) {
                first.add(num);
            } else if (countFirst < countSecond) {
                second.add(num);
            } else {
                if (first.size() < second.size()) {
                    first.add(num);
                } else if (first.size() > second.size()) {
                    second.add(num);
                } else {
                    first.add(num);
                }
            }
        }

        first.addAll(second);
        int[]ans  = new int[first.size()];
        for(int i = 0 ; i<first.size(); i++){
            ans[i] = first.get(i);
        }
        return ans;
    }
}
