class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (null == prices || prices.length == 0)
            return 0;
        int s0 =0, s1 = -0x3f3f3f3f;
        for (int p:prices) {
            int tmp = s0;
            s0 = Math.max(s0, s1+p-fee);
            s1 = Math.max(s1, tmp-p);
        }
        return s0;
    }
    public static void main(String[] args) {
        int[] a = {1,3,2,8,4,9};
        Solution s = new Solution();
        System.out.println(s.maxProfit(a, 2));
    }
}