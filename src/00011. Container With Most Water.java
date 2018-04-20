public class Solution {
    public int maxArea(int[] height) {
        if (height.length < 2) return 0;
        int ans = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int v = (r - l) * Math.min(height[l], height[r]);
            if (v > ans) ans = v;
            if (height[l] < height[r]) l++;
            else r--;
        }
        return ans;
    }
}