class Solution {
    private int binarySearch(final int[] nums, final int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left+right) >>1;
            if (nums[mid] < target)
                left = mid +1;
            else
                right = mid;
        }
        return left;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        int left = binarySearch(nums, target);
        int right = binarySearch(nums, target+1);
        if (left ==nums.length || nums[left] != target)
            return new int[]{-1, -1};
        return new int[]{left, right-1};
    }
}