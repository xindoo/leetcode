class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] vMax = new int[grid.length];
        int[] hMax = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                vMax[i] = Math.max(vMax[i], grid[i][j]);
                hMax[j] = Math.max(hMax[j], grid[i][j]);
            }
        }
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans += Math.min(vMax[i], hMax[j]) - grid[i][j];
            }
        }
        return ans;
    }
}