import java.util.HashMap;
import java.util.Map;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (k > n) {
            return 0;
        }

        long maxSum = 0;
        long windowSum = 0;
        Map<Integer, Integer> windowMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            windowSum += nums[i];
            windowMap.put(nums[i], windowMap.getOrDefault(nums[i], 0) + 1);

            if (i >= k) {
                int left = nums[i - k];
                windowSum -= left;
                windowMap.put(left, windowMap.get(left) - 1);
                if (windowMap.get(left) == 0) {
                    windowMap.remove(left);
                }
            }

            if (i >= k - 1 && windowMap.size() == k) {
                maxSum = Math.max(maxSum, windowSum);
            }
        }

        return maxSum;
    }
}