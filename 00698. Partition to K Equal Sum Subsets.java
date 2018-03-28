class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        boolean[] isUsed = new boolean[nums.length];
        int sum = 0;
        for (int num : nums ) sum += num;
        if (sum%k != 0) return false;
        int avg = sum/k;
        return dfs(nums, isUsed, k, avg, avg, 0);
    }

    private boolean dfs(int[] nums, boolean[] isUsed, int k, int target, int cur, int pos) {
        if (1 == k)
            return true;
        if (0 == cur)
            return dfs(nums, isUsed, k-1, target, target, 0);
        for (int i = pos; i < nums.length; i++) {
            if (isUsed[i] || nums[i] > target) {
                continue;
            }
            isUsed[i] = true;
            if(dfs(nums, isUsed, k, target, cur-nums[i], i+1)) {
                return true;
            }
            isUsed[i] = false;
        }
        return false;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canPartitionKSubsets(new int[]{4,5,3,2,5,5,5,1,5,5,5,5,5,5,5,5}, 14));
    }
}