class Solution {
    public int trap(int[] height) {
        if (null == height || height.length == 0)
            return 0;
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = height[0];
        right[len-1] = height[len-1];
        for (int i = 1; i < len-1; i++) {
            left[i] = Math.max(height[i], left[i-1]);
            right[len-1-i] = Math.max(height[len-1-i], right[len-i]);
        }
        int res = 0;
        for (int i = 1; i < len-1; i++) {
            int tmp = Math.min(left[i-1], right[i+1]) - height[i];
            if (tmp > 0)
                res += tmp;
        }
        return res;
    }
}