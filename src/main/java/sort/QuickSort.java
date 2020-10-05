package sort;

import java.util.Arrays;

public class QuickSort {

    public int[] quickSort(int[] nums) {
        quick(nums, 0, nums.length - 1);
        return nums;
    }

    public void quick(int[] nums, int left, int right) {
        if (left > right) return;
        int i = left, j = right;
        int base = nums[i];
        while (i < j) {
            while (i < j && nums[j] >= base) j--;
            if (i < j) {
                nums[i] = nums[j];
                i++;
            }
            while (i < j && nums[i] <= base) i++;
            if (i < j) {
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = base;
        quick(nums, left, i - 1);
        quick(nums, i + 1, right);
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] nums = {2,4,1,5,2,1,5,7,8,3};
        qs.quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
