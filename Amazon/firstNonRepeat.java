class Solution {
    public int firstUniqChar(String s) {
        int min = Integer.MAX_VALUE;
        for (char c = 'a'; c <= 'z'; c++) {
            int inx = s.indexOf(c);
            if (inx != -1 && inx == s.lastIndexOf(c))
                min = Math.min(min, inx);
        }
        return (min != Integer.MAX_VALUE) ? min : -1;
    }
}