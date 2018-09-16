import java.util.Arrays;

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length-1;
        int num1 = nums[len] *  nums[len-1] *  nums[len-2];
        int num2 = nums[0] *  nums[1] *  nums[len];
        return Math.max(num1, num2);
    }
}