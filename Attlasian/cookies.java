class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int j = 0; // Start of s
        int i = 0; // Start of g
        int count = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) { // if the current cookie can satisfy the current child's greed factor
                count++;
                i++;
            }
            j++;
        }
        return count;
    }
}