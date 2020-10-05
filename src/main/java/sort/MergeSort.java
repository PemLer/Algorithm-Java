package sort;

import java.util.Arrays;

public class MergeSort {

    public int[] mergeSort(int[] nums) {
        int n = nums.length;
        int[] tmp = new int[n];
        merge(nums, tmp, 0, n - 1);
        return nums;
    }

    public int[] merge(int[] nums, int[] tmp, int left, int right) {
        if (left >= right) return null;
        int mid = left + right >> 1;
        merge(nums, tmp, left, mid);
        merge(nums, tmp, mid + 1, right);
        int i = left, j = mid + 1, pos = left;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                tmp[pos] = nums[i];
                i++;
            } else {
                tmp[pos] = nums[j];
                j++;
            }
            pos++;
        }
        for (int k = i; k <= mid; k++) {
            tmp[pos] = nums[k];
            pos++;
        }
        for (int k = j; k <= right; k++) {
            tmp[pos] = nums[k];
            pos++;
        }
        System.arraycopy(tmp, left, nums, left, right - left + 1);
        return nums;
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] nums = {2, 3, 4, 1, 2, 0, 8, 5, 8};
        ms.mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
