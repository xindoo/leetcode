class Solution {
    private int[] dx = new int[]{1, -1, 0, 0};
    private int[] dy = new int[]{0, 0, 1, -1};
    public void solve(char[][] board) {
        if (board == null || board.length == 0) 
            return;
        int cols = board.length;
        int rows = board[0].length;

        for (int col = 0; col < cols; col++) {
            solve(board, col, 0);
            solve(board, col, rows-1);
        }

        for (int row = 0; row < rows; row++) {
            solve(board, 0, row);
            solve(board, cols-1, row);
        }

        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                board[col][row] = board[col][row] == 'Z' ? 'O' : 'X';
            }
        }
    }

    public void solve(char[][] board, int col, int row) {
        if (col < 0 || col >= board.length || row < 0 || row >= board[0].length)
            return;
        if (board[col][row] == 'X' || board[col][row] == 'Z')
            return;
        board[col][row] = 'Z';
        for (int i = 0; i < 4; i++) {
            solve(board, col+dx[i], row+dy[i]);
        }
    }
}