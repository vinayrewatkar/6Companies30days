class Solution {
    public int maxRotateFunction(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int sum = 0;
        int dp = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            dp = dp + i * nums[i];
        }
        int max = dp;
        for (int i = 1; i < nums.length; i++) {
            int Sum = sum + dp - (nums.length) * nums[nums.length - i];
            max = Math.max(Sum, max);
            dp = Sum;
        }
        return max;
    }
}