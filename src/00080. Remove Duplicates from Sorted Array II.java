class Solution {
    public int removeDuplicates(int[] nums) {
        if (null == nums)
            return 0;
        if (nums.length <= 2)
            return nums.length;
        int res = 1;
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == last) {
                nums[res++] = nums[i];
                while (i < nums.length && nums[i] == last) {
                    i++;
                }
                i--;
            } else {
                nums[res++] = nums[i];
                last = nums[i];
            }
        }
        return res;
    }
}