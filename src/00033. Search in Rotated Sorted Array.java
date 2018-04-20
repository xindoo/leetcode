class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            int mid = (left+right)>>1;
            if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid]))
                left = mid +1;
            else
                right = mid;
        }
        return left == right && nums[left] == target? left:-1;
    }
}