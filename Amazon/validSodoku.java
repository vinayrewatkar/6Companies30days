class Solution {
    public boolean isValidSudoku(char[][] board) {
        int boxes[][] = new int[9][9];
        int rows[][] = new int[9][9];
        int cols[][] = new int[9][9];
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                int pos = board[r][c] - '1';
                if (rows[r][pos] == 1) {
                    return false;
                }
                rows[r][pos] = 1;
                if (cols[c][pos] == 1) {
                    return false;
                }
                cols[c][pos] = 1;
                int idx = r / 3 * 3 + c / 3;
                if (boxes[idx][pos] == 1) {
                    return false;
                }
                boxes[idx][pos] = 1;
            }

        }
        return true;
    }
}