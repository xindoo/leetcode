class Solution {
    public int surfaceArea(int[][] grid) {
        if (null == grid || grid.length == 0) {
            return 0;
        }
        int sum = 0;
        int top = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    top += 1;
                }
            }
        }
        int left = 0;
        for (int i = 0; i < grid.length; i++) {
            int pre = 0;
            int next;
            for (int j = 0; j < grid[0].length; j++) {
                if (j + 1 == grid[0].length) {
                    next = 0;
                } else {
                    next = grid[i][j+1];
                }
                if (grid[i][j] - pre > 0) {
                    left += grid[i][j] - pre;
                }
                if (grid[i][j] - next > 0) {
                    left += grid[i][j] - next;
                }
                pre = grid[i][j];
            }
        }
        int right = 0;
        for (int i = 0; i < grid[0].length; i++) {
            int pre = 0;
            int next = 0;
            for (int j = 0; j < grid.length; j++) {
                if (j + 1 == grid.length) {
                    next = 0;
                } else {
                    next = grid[j+1][i];
                }
                if (grid[j][i] - pre > 0) {
                    right += grid[j][i] - pre;
                }
                if (grid[j][i] - next > 0) {
                    right += grid[j][i] - next;
                }

                pre = grid[j][i];
            }
        }
        return top*2 + left + right;
    }
}