package T101_200;

class Solution152 {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int maxValue = 1, minValue = 1;
        for (int num : nums) {
            if (num < 0) {
                int tmp = maxValue;
                maxValue = minValue;
                minValue = tmp;
            }
            maxValue = Math.max(maxValue * num, num);
            minValue = Math.min(minValue * num, num);
            res = Math.max(res, maxValue);
        }
        return res;
    }
}