public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = 0x3f3f3f3f;
        }
        for(int coin:coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = dp[i] < dp[i-coin]+1 ? dp[i]:dp[i-coin]+1;
            }
        }
        if (0x3f3f3f3f == dp[amount])
            dp[amount] = -1;
        return dp[amount];
    }
}