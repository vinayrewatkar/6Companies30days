class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(nums[o1], nums[o2]));
        for (int i = 0; i < nums.length; i++) {
            if (pq.size() < k) {
                pq.add(i);
            } else if (nums[pq.peek()] < nums[i]) {
                pq.poll();
                pq.add(i);
            }
        }
        int[] res = new int[k];
        Set<Integer> indexes = new HashSet<>(pq);
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (indexes.contains(i)) {
                res[j++] = nums[i];
            }
        }
        return res;
    }
}