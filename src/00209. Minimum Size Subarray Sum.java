class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (null == nums || nums.length == 0)
            return 0;
        int l = 0, r = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while (r < nums.length){
            sum += nums[r++];
            while (sum >= s) {
                res = Math.min(res, r - l);
                sum -= nums[l++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}