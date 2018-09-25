/**
 * 和House Robber 一样,也是道动态规划, 不一样之处在于要分别考虑偷第一户和不偷
 * 第一户的情况, 这里我用三维数据来做了 dp[i][1][0] 标识到第i户, 偷了第一户的
 * 情况下不投i的最大值. 三个维度分别是  第i户, 是否偷了第一户, 是否偷了第i户时
 * 候的最大值. 
 */
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int[][][] dp = new int[nums.length+1][2][2];
        dp[1][1][1] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            dp[i+1][0][0] = Math.max(dp[i][0][0], dp[i][0][1]);
            dp[i+1][0][1] = dp[i][0][0] + nums[i];
            dp[i+1][1][0] = Math.max(dp[i][1][0], dp[i][1][1]);
            dp[i+1][1][1] = dp[i][1][0] + nums[i];
        }
        return Math.max(dp[nums.length][1][0], Math.max(dp[nums.length][0][0], dp[nums.length][0][1]));
    }
}