/*
 * 简单dfs，算下统计下联通块的数量，然后取最大的一块，bfs也可以做，但dfs递归实现版比较容易写
 *
 */
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length < 1) 
            return 0;
        int max = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                max = Math.max(max,dfs(grid, i,j));
            }
        }
        return max;
    }
    
    public int dfs(int [][] grid, int r, int c){
        if (r< 0 || c<0 || r>=grid.length || c >=grid[0].length) 
            return 0;
        if (grid[r][c] <= 0) 
            return 0;
        int val = grid[r][c];
        grid[r][c]--;
        return val + dfs(grid, r+1, c) + dfs(grid,r-1, c) + dfs(grid,r,c+1) + dfs(grid,r,c-1);
    }
}