class Solution {
    public int findTheWinner(int n, int k) {
        if (n == 1)
            return 1;
        int element = findTheWinner(n - 1, k);
        int ans = (element + k) % n;
        return ans == 0 ? n : ans;
    }
}