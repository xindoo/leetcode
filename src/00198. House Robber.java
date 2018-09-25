class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[nums.length+1][2];
        for(int i = 0; i < nums.length; i++) {
            dp[i+1][1] = Math.max(dp[i][1], dp[i][0] + nums[i]);
            dp[i+1][0] = Math.max(dp[i][0], dp[i][1]);
        }
        return Math.max(dp[nums.length][0], dp[nums.length][1]);
    }
}