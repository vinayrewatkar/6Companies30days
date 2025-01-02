class Solution {
    public int maxProduct(String s) {
        return solve(0, s, "", "");
    }

    public int solve(int index, String s, String subseq1, String subseq2) {
        if (index == s.length()) {
            if (isPalindrome(subseq1) && isPalindrome(subseq2)) {
                return subseq1.length() * subseq2.length();
            }
            return 0;
        }
        int takeInFirst = solve(index + 1, s, subseq1 + s.charAt(index), subseq2);
        int takeInSecond = solve(index + 1, s, subseq1, subseq2 + s.charAt(index));
        int skip = solve(index + 1, s, subseq1, subseq2);
        return Math.max(takeInFirst, Math.max(takeInSecond, skip));
    }

    public boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
