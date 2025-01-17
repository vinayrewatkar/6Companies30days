class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxH = findMaxDistance(hBars);
        int maxV = findMaxDistance(vBars);
        return (int) Math.pow(Math.min(maxV, maxH), 2);
    }

    private int findMaxDistance(int[] bars) {
        Arrays.sort(bars);
        int maxDistance = 1;
        int current = bars[0] - 1;
        for (int i = 1; i < bars.length; i++) {
            if (bars[i] - bars[i - 1] != 1) {
                maxDistance = Math.max(maxDistance, bars[i - 1] + 1 - current);
                current = bars[i] - 1;
            }
        }
        return Math.max(maxDistance, bars[bars.length - 1] + 1 - current);
    }
}