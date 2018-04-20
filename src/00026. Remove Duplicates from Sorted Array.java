class Solution {
    public int removeDuplicates(int[] nums) {
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[len] = nums[i];
                len += 1;
            }
        }
        return len;
    }
}