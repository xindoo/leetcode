public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int a = 0x7fffffff, b = 0x7fffffff;
        for (int num:nums) {
            if (num < a)
                a = num;
            else if (num > a) {
                if (b < num)
                    return true;
                b = num;
            }
        }
        return false;
    }
}