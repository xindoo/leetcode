class Solution {
    public int findLength(int[] a, int[] b) {

        int m = a.length;
        int n = b.length;
        int[][] dp = new int[m + 1][n + 1];
        int ans = 0;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else
                    dp[i][j] = 0;
            }
        }
        return ans;
    }
}