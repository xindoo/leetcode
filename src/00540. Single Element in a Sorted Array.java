class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int l = 0;
        int r = nums.length-1;
        while (l != r) {
            int mid = (l+r) >> 1;
            if (nums[mid/2*2] != nums[mid/2*2+1]) {
                r = mid;
            } else {
                l = mid+1;
            }
        }
        return nums[l];
    }
}