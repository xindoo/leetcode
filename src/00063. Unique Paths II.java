public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (1 == obstacleGrid[i][j]) {
                    obstacleGrid[i][j] = 0;
                    continue;
                }
                if (0 == i + j) {
                    obstacleGrid[i][j] = 1;
                    continue;
                } else if (0 == i) {
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                } else if (0 == j) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }
        return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] a = {{0,0,0}, {0,1,0}, {0,0,0}};
        s.uniquePathsWithObstacles(a);
    }
}