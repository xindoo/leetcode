class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[][] wallet = new int[3][prices.length];// 0 cooldown, 1 have stock, 2 don't have stock
        wallet[1][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            wallet[0][i] = Math.max(wallet[0][i - 1], wallet[2][i - 1]);
            wallet[1][i] = Math.max(wallet[1][i - 1], wallet[0][i - 1] - prices[i]);
            wallet[2][i] = wallet[1][i - 1] + prices[i];
        }
        return Math.max(wallet[0][prices.length-1], wallet[2][prices.length-1]);
    }
}