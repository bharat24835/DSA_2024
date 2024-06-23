package Array.Easy;

import java.util.HashMap;
import java.util.Map;

public class Question_4 {
    public static void main(String[] args) {
        int[]a = {910,6961,6961,1440,910,910,9791,9088,1440,1440,9791,9791,6961,9088,9088};
        int k = 6;
        System.out.println(solution(a , k));
        System.out.println(countContiguousSubarraysWithDuplicates(a , k));
        System.out.println(countContiguousSubarraysWithDuplicates2(a ,k));

    }
    public static  int solution(int[] numbers, int k) {
        int count=0;

        HashMap<Integer,Integer> map=new HashMap<>();
        int dispair=0;
        int l=0;
        for(int r=0;r<numbers.length;r++)
        {
            int num=numbers[r];
            map.put(num,map.getOrDefault(num,0)+1);
            if(map.get(num)==2)
            {
                dispair++;
            }
            else if(map.get(num)>2)
            {
                dispair--;
            }
            while(dispair>=k)
            {
                count+=numbers.length-r;
                int lnum=numbers[l];
                map.put(lnum,map.get(lnum)-1);
                if(map.get(lnum)==1)
                {
                    dispair--;
                }
                l++;
            }
        }
        return count;

    }
    public static int countContiguousSubarraysWithDuplicates(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (countDuplicates(nums, i, j) >= k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int countDuplicates(int[] nums, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }
    public static int countContiguousSubarraysWithDuplicates2(int[] nums, int k) {
        int count = 0;
        int size = 2*k;

        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> freqMap = new HashMap<>();
            for (int j = i; j < nums.length; j++) {
                if(j-i+1 < size) continue;
                freqMap.put(nums[j], freqMap.getOrDefault(nums[j], 0) + 1);
                int duplicatesCount = freqMap.values().stream().mapToInt(Integer::intValue).filter(v -> v == 2).sum();
                if (duplicatesCount == 2 * k) {
                    count++;
                }
            }
        }
        return count;
    }
    public  static int call(int[]a , int k){
        int count =0 ;
        int size = 2*k;
        int i =  0;
        int j = 0;

        Map<Integer , Integer>map = new HashMap<>();

        while( j < a.length){
            map.put(a[j]  , map.getOrDefault(a[j] , 0)+1);

            if(j-i+1 < size)continue;


            j++;
        }
        return 0;
    }
}
