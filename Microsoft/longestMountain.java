public class longestMountain {
    public int longestMountain(int[] arr) {
        if (arr.length < 3) {
            return 0;
        }
        int largest = 0;

        for (int i = 1; i < arr.length - 1; i++) {
            int up = 0;
            int down = 0;
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                for (int j = i; j > 0; j--) {
                    if (arr[j] > arr[j - 1]) {
                        up++;
                    } else {
                        break;
                    }
                }
                for (int j = i; j < arr.length - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        down++;
                    } else {
                        break;
                    }
                }
                largest = Math.max(largest, up + down + 1);
            }
        }
        return largest;
    }
}