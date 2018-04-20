class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (String str : strs) {
            int cntz = 0;
            int cnto = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') {
                    cntz++;
                } else {
                    cnto++;
                }
            }
            for (int i = m; i >= cntz; i--) {
                for (int j = n; j >= cnto; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - cntz][j - cnto] + 1);
                }
            }
        }
        return dp[m][n];
    }
}