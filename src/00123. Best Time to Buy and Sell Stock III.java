class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1)
            return 0;

        int[][] dp = new int[3][n];
        for (int i = 1; i <= 2; i++) {
            int localMax = dp[i-1][0] - prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j-1],  prices[j] + localMax);
                localMax = Math.max(localMax, dp[i-1][j] - prices[j]);
            }
        }
        return Math.max(dp[2][n-1], dp[1][n-1]);
    }
}