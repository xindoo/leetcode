class Solution {
    public void moveZeroes(int[] nums) {
        int num_non_zeroes = 0;
        int swap;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap = nums[i];
                nums[i] = 0;
                nums[num_non_zeroes] = swap;
                num_non_zeroes++;
            }
        }
    }
}