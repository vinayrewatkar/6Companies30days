class Solution {
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        int[] copy = Arrays.copyOf(nums, len);
        Arrays.sort(copy);
        int half = len / 2 - 1 + (len % 2);
        int index = 0;
        for (int i = half; i >= 0; i--) {
            nums[index++] = copy[i];
            int lastIndex = len - 1 - (half - i);
            if (0 == i) {
                if (lastIndex > half) {
                    nums[index++] = copy[lastIndex];
                }
            } else {
                nums[index++] = copy[lastIndex];
            }
        }
    }
}