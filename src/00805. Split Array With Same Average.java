class Solution {
    public boolean splitArraySameAverage(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        boolean dp[][] = new boolean[A.length+1][sum+1];
        dp[0][0] = true;
        for (int i = 0; i < A.length; i++) {
            for (int j = sum; j >= A[i]; j--) {
                for (int k = 1; k <= A.length; k++) {
                    dp[k][j] = dp[k][j]|dp[k-1][j-A[i]];
                }
            }
        }
        for (int i = 1; i <= A.length/2; i++) {
            if (sum*i % A.length == 0) {
                if (dp[i][sum * i / A.length]) {
                    return true;
                }
            }
        }
        return false;
    }
}