public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int mul = 1;
        int[] ans = new int[nums.length];
        int cntzero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                cntzero ++;
            else 
                mul *= nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (cntzero > 1)
                    ans[i] = 0;
                else 
                    ans[i] = mul;
            }
            else {
                if (cntzero > 0)
                    ans[i] = 0;
                else 
                    ans[i] = mul/nums[i];
            }
        }
        return ans;
    }
}