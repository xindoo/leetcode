class Solution {
    final private int[] dirx = {0, 1, -1, 0};
    final private int[] diry = {1, 0, 0, -1};

    public boolean dfs(char[][] board, String word, int row, int col, int start) {
        if (start == word.length()) {
            return true;
        }
        char cur = word.charAt(start);
        for (int i = 0; i < 4; i++) {
            int nrow = row + dirx[i];
            int ncol = col + diry[i];
            if (nrow >= 0 && nrow < board.length && ncol >= 0 && ncol < board[0].length && cur == board[nrow][ncol]) {
                board[nrow][ncol] = '#';
                if (dfs(board, word, nrow, ncol, start + 1)) {
                    return true;
                }
                board[nrow][ncol] = cur;
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;
        if (word.equals("")) return true;
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                char temp = board[i][j];
                if (temp == word.charAt(0)) {
                    board[i][j] = '#';
                    if (dfs(board, word, i, j, 1)) {
                        return true;
                    }
                    board[i][j] = temp;
                }
            }
        }
        return false;
    }
}