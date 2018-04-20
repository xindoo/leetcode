public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (0 == len)
            return 0;
        int[] minlift = new int[len];
        int[] maxright = new int[len];
        minlift[0] = prices[0];
        maxright[len-1] = prices[len-1];
        for (int i = 1; i < len; i++) {
            minlift[i] = Math.min(prices[i], minlift[i-1]);
            maxright[len-1-i] = Math.max(prices[len-1-i], maxright[len-i]);
        }
        int ans = 0;
        for (int i = 1; i < len; i++) {
            ans = Math.max(ans, maxright[i] - minlift[i-1]);
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {7,1,5,3,6,4};
        s.maxProfit(a);
    }
}