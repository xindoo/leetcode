class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2)
            return;
        int i, j;
        for (i  = nums.length - 2; i >= 0; i--) {
             if (nums[i] < nums[i+1]) {
                 break;
             }
        }
        if (i != -1) {
            for (j = nums.length - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                    break;
                }
            }
        }
        for (int k = 0; k < (nums.length-1-i)>>1; k++) {
            int t = nums[i+1+k];
            nums[i+1+k] = nums[nums.length-1-k];
            nums[nums.length-1-k] = t;
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,3,2};
        Solution s = new Solution();
        for (int i = 0; i < 10; i++) {
            s.nextPermutation(nums);
            System.out.println(nums);
        }
    }
}