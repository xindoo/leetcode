public class Solution {
    public int rob(int[] nums) {
        if (0 == nums.length)
            return 0;
        int[][] dp = new int[2][nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (0 == i) {
                dp[0][0] = 0;
                dp[1][0] = nums[0];
            }
            else if (1 == i) {
                dp[0][1] = nums[0];
                dp[1][1] = nums[1];
            }
            else {
                dp[0][i] = Math.max(dp[0][i-1], dp[1][i-1]);
                dp[1][i] = Math.max(dp[1][i-1], dp[0][i-1]+nums[i]);
            }
        }
        return Math.max(dp[0][nums.length-1], dp[1][nums.length-1]); 
    }
}