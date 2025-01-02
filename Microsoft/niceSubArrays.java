import java.util.HashMap;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int oddCount = 0, result = 0;

        // Initialize the hashmap to handle the case where the prefix sum equals k
        countMap.put(0, 1);

        for (int num : nums) {
            // Increment oddCount if the current number is odd
            if (num % 2 == 1) {
                oddCount++;
            }

            // Check if there exists a prefix with (oddCount - k)
            result += countMap.getOrDefault(oddCount - k, 0);

            // Update the count of the current oddCount in the hashmap
            countMap.put(oddCount, countMap.getOrDefault(oddCount, 0) + 1);
        }

        return result;
    }
}
