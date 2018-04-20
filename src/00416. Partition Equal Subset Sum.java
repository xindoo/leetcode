public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum%2 == 1)
            return false;
        int subsum = sum/2;
        int[] dp = new int[subsum+1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = subsum; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-nums[i]] + nums[i]);
            }
        }
        return dp[subsum] == subsum;
    }
}
