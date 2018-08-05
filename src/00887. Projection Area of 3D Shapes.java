class Solution {
    public int projectionArea(int[][] grid) {
        if (null == grid || grid.length == 0)
            return 0;
        int top = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 0) {
                    top += 1;
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            int maxleft = 0;
            for (int j = 0; j < grid[0].length; j++) {
                maxleft = Math.max(maxleft, grid[i][j]);
            }
            left += maxleft;

        }

        for (int i = 0; i < grid[0].length; i++) {
            int maxright = 0;
            for (int j = 0; j < grid.length; j++) {
                maxright = Math.max(maxright, grid[j][i]);
            }
            right += maxright;
        }
        return top + left + right;
    }
}