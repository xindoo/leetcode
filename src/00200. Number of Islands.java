public class Solution {
    int[] dirx = {-1, 0, 1, 0};
    int[] diry = {0, 1, 0, -1};
    void dfs(char[][] grid, int a, int b) {
        int x = grid.length;
        int y = grid[0].length;
        if ('1' == grid[a][b]) {
            grid[a][b] = '0';
        }
        else {
            return ;
        }
        for (int i = 0; i < 4; i++) {
            int nextx = a + dirx[i];
            int nexty = b + diry[i];
            if (nextx >= 0 && nextx < x && nexty >= 0 && nexty < y) {
                dfs(grid, nextx, nexty);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int x = grid.length;
        int y = 0;
        if (0 != x) {
            y = grid[0].length;
        }
        int ans = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if ('1' == grid[i][j]) {
                    ans += 1;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }
}