class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int end = Math.min(nums.length-i, nums[i]+1);
            for (int j = max - i + 1; j < end; j++) {
                dp[i+j] = Math.min(dp[i+j], dp[i]+1);
                if (i+j == nums.length-1) {
                    return dp[nums.length-1];
                }
                max = i+j;
            }
        }
        return dp[nums.length-1];
    }
}