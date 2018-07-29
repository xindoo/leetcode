class Solution {
    int[][][] dp;
    public boolean stoneGame(int[] piles) {
        dp = new int[piles.length][piles.length][2];
        int len = piles.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            dp[i][i][0] = piles[i];
            dp[i][i][1] = piles[i];
            sum += piles[i];
        }
        return  help(0, len-1, 0, piles)> sum/2;
    }
    private int help(int i, int j, int pos, int[] piles) {
        if (dp[i][j][pos] != 0) {
            return dp[i][j][pos];
        }
        int newpos = pos^1;
        dp[i][j][newpos] = Math.max(help(i+1, j, newpos, piles), help(i, j-1, newpos, piles));
        dp[i][j][pos] = Math.max(help(i+1, j, newpos, piles)+piles[i+1], help(i, j-1, newpos, piles)+piles[j-1]);
        return dp[i][j][pos];
    }
}