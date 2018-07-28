class Solution {
    public int maxProduct(int[] nums) {
        int dpMax[] = new int[nums.length];  //positive
        int dpMin[] = new int[nums.length];  //negative
        int maxP = nums[0];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(Math.max(dpMax[i-1] * nums[i], dpMin[i-1] * nums[i]), nums[i]);
            dpMin[i] = Math.min(Math.min(dpMax[i-1] * nums[i], dpMin[i-1] * nums[i]), nums[i]);
            maxP = Math.max(dpMax[i], maxP);
        }
        return maxP;
    }
}