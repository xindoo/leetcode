class Solution {
    public int dominantIndex(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++)  {
            if (nums[ans] < nums[i]) {
                ans = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] * 2 > nums[ans] && i != ans) {
                return -1;
            }
        }
        return ans;
    }
}