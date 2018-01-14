public class Solution {
    private boolean[][] vis;
    public boolean judge(int x, int y, int n) {
        if(x >= n || y >= n || x < 0 || y < 0 || vis[x][y] == true)
            return false;
        return true;
    }
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        vis = new boolean[n][n];
        int[] dirx = {0, 1, 0, -1};
        int[] diry = {1, 0, -1, 0};
        int total = n*n;
        int dir = 0;
        int posx = 0;
        int posy = 0;
        for (int i = 1; i <= total; i++) {
            if (judge(posx, posy, n)) {
                ans[posx][posy] = i;
                vis[posx][posy] = true;
                posx += dirx[dir];
                posy += diry[dir];
            }
            else {
                posx -= dirx[dir];
                posy -= diry[dir];
                vis[posx][posy] = false;
                dir += 1;
                dir %= 4;
                i -= 2;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] ans = s.generateMatrix(5);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans.length; j++)
                System.out.print(" "+ans[i][j]);
            System.out.println();
        }
    }
}