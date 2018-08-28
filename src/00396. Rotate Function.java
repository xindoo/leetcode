class Solution {
    public int maxRotateFunction(int[] A) {
        if (null == A || A.length == 0) {
            return 0;
        }
        int F = 0;
        int sum = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            F += i*A[i];
            sum += A[i];
        }
        int maxF = F;
        
        for (int i = 1; i < n; i++) {
            int index = n - i;
            F = F + sum - n*A[index];
            maxF = Math.max(maxF, F);
        }
        return maxF;
    }
}