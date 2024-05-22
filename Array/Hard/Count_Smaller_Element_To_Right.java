package Array.Hard;

import java.util.ArrayList;
import java.util.List;

public class Count_Smaller_Element_To_Right {
    public static void main(String[] args) {
        int[]a = {0,0,20 ,6,16,5,36};
        System.out.println(call(a));
    }
    public static List<Integer> call(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[] count = new int[nums.length];
        int[] indexes = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexes[i] = i;
        }
        mergeSort(nums, indexes, count, 0, nums.length - 1);
        for (int i = 0; i < count.length; i++) {
            result.add(count[i]);
        }
        return result;
    }
    public static void mergeSort(int[] nums, int[] indexes, int[] count, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(nums, indexes, count, start, mid);
        mergeSort(nums, indexes, count, mid + 1, end);
        merge(nums, indexes, count, start, mid, end);
    }
    public static void merge(int[] nums, int[] indexes, int[] count, int start, int mid, int end) {
        int[] tempIndexes = new int[end - start + 1];
        int left = start, right = mid + 1, index = 0, smallerCount = 0;
        while (left <= mid && right <= end) {
            if (nums[indexes[right]] < nums[indexes[left]]) {
                tempIndexes[index++] = indexes[right++];
                smallerCount++;
            } else {
                tempIndexes[index++] = indexes[left];
                count[indexes[left++]] += smallerCount;
            }
        }
        while (left <= mid) {
            tempIndexes[index++] = indexes[left];
            count[indexes[left++]] += smallerCount;
        }
        while (right <= end) {
            tempIndexes[index++] = indexes[right++];
        }
        System.arraycopy(tempIndexes, 0, indexes, start, tempIndexes.length);
    }
}
