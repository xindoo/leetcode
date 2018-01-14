public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            dp[i] = 0x3f3f3f3f;
        }
        for (int i = 1; i*i <= n;i++) {
            for (int j = i*i; j <= n; j++) {
                dp[j] = dp[j]<(dp[j - i*i] +1)?dp[j]:(dp[j - i*i] +1);
            }
        }
        return dp[n];
    }
}