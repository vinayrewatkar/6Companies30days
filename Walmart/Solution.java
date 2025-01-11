import java.util.*;

public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n]; // dp[i] will be the size of the largest divisible subset ending with nums[i]
        int[] prev = new int[n]; // prev[i] will store the previous index in the subset chain
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxSize = 0;
        int maxIndex = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxIndex = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        while (maxIndex != -1) {
            result.add(nums[maxIndex]);
            maxIndex = prev[maxIndex];
        }

        Collections.reverse(result); // Reverse to get the subset in correct order
        return result;
    }
}