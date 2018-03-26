class Solution {
    public int findPeakElement(int[] nums) {
        int[] max = new int[nums.length+1];
        max[nums.length] = Integer.MIN_VALUE;
        for (int i = nums.length-1; i > 0; i--) {
            max[i] = Math.max(nums[i], max[i+1]);
        }
        int maxl = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= maxl && nums[i] >= max[i+1]) {
                return i;
            }
            maxl = Math.max(maxl, nums[i]);
        }
        return 0;
    }
}