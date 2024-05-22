package Contest_LeetCode.May_5;

import java.util.*;

public class Question3 {
    public static void main(String[] args) {
        String s = "xxe";
        //System.out.println(call(s));
        System.out.println(findOriginalString(s).length());
    }
    public static int call(String s){
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i<s.length(); i++){
            int item = s.charAt(i)-'a';

            set.add(item);
        }
        int size = set.size();

        int i = 0;
        int j = 0;
        int ans = Integer.MAX_VALUE;
        int unique = 0;
        int[]count = new int[26];
        Set<Integer>temp_set = new HashSet<>();

        while( j <s.length()){
            // picking jth element
            int element = s.charAt(j)-'a';
            if(!temp_set.contains(element)){
                temp_set.add(element);
            }
            else{
                // compress
                while(i< s.length() && temp_set.contains(element)){
                    int first = s.charAt(i)-'a';
                    temp_set.remove(first);
                    i++;
                }
            }
            if(temp_set.size() == size){
                ans = Math.min(j-i+1 , ans);
            }
            j++;

        }
        return ans;
    }

    public static List<Integer> factors(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                result.add(i);
            }
        }
        return result;
    }

    // Helper function to check if all segments of a given length have identical character frequencies
    public static boolean isUniform(String s, int segmentLength) {
        int n = s.length();
        String firstSegment = s.substring(0, segmentLength);
        Map<Character, Integer> initialCount = getCharCount(firstSegment);

        for (int i = segmentLength; i < n; i += segmentLength) {
            String currentSegment = s.substring(i, i + segmentLength);
            Map<Character, Integer> currentCount = getCharCount(currentSegment);
            if (!initialCount.equals(currentCount)) {
                return false;
            }
        }
        return true;
    }

    // Helper function to count characters in a string
    public static Map<Character, Integer> getCharCount(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        return charCount;
    }

    public static String findOriginalString(String s) {
        int n = s.length();

        // Find the smallest segment length that has consistent character frequencies
        int segmentLength = -1;
        for (int factor : factors(n)) {
            if (isUniform(s, factor)) {
                segmentLength = factor;
                break;
            }
        }

        if (segmentLength > 0) {
            String firstSegment = s.substring(0, segmentLength);
            char[] sortedSegment = firstSegment.toCharArray();
            Arrays.sort(sortedSegment);
            return new String(sortedSegment);
        }

        return null;
    }
}
