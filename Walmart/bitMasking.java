import java.util.HashMap;

class Solution {
    private static final int MOD = 1000000007;

    public int squareFreeSubsets(int[] nums) {
        int n = nums.length;

        // Precompute prime factor masks for numbers 1 to 30
        int[] primeMasks = new int[31];
        int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
        for (int i = 1; i <= 30; i++) {
            int mask = 0, num = i;
            for (int j = 0; j < primes.length; j++) {
                int prime = primes[j];
                int count = 0;
                while (num % prime == 0) {
                    num /= prime;
                    count++;
                }
                if (count > 1) { // Not square-free
                    mask = -1;
                    break;
                }
                if (count == 1)
                    mask |= (1 << j);
            }
            primeMasks[i] = mask;
        }

        // Dynamic Programming with bitmask
        HashMap<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1); // Base case: 1 way to form the empty subset

        for (int num : nums) {
            int primeMask = primeMasks[num];
            if (primeMask == -1)
                continue; // Skip non-square-free numbers

            // Update DP table
            HashMap<Integer, Integer> newDp = new HashMap<>(dp);
            for (int mask : dp.keySet()) {
                if ((mask & primeMask) == 0) { // No overlapping prime factors
                    int newMask = mask | primeMask;
                    newDp.put(newMask, (newDp.getOrDefault(newMask, 0) + dp.get(mask)) % MOD);
                }
            }
            dp = newDp;
        }

        // Sum up all subsets (excluding the empty subset)
        int result = 0;
        for (int count : dp.values()) {
            result = (result + count) % MOD;
        }

        // Subtract 1 to exclude the empty subset
        return (result - 1 + MOD) % MOD;
    }
}
