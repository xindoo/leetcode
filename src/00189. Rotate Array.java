import java.util.Arrays;

class Solution {
    public void rotate(int[] nums, int k) {
        int tmp[] = Arrays.copyOf(nums, nums.length);
        k %= nums.length;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = tmp[(nums.length - k + i) % nums.length];
        }
    }
}