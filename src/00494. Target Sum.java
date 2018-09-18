/**
 * 最多20个数, 总共2^20 100w种状态, 递归遍历下就就好了.
 */
class Solution {
    private int cnt = 0;
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        dfs(nums, 0, 0, S);
        return cnt;
    }
    private void dfs(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S) {
                cnt++;
            }
            return;
        }
        dfs(nums, i+1, sum+nums[i], S);
        dfs(nums, i+1, sum-nums[i], S);
    }
}