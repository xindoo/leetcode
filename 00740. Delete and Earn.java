class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = 10000;
        int maxval = 0;
        int[] arr = new int[n+1];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] += nums[i];
            maxval = Math.max(maxval, nums[i]);
        }
        int[][] dp = new int[maxval+1][2];
        for (int i = 1; i <= maxval; i++) {
            dp[i][1] = dp[i-1][0] + arr[i];
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
        }
        return Math.max(dp[maxval][0], dp[maxval][1]);
    }
}