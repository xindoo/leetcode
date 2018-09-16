class Solution {
    public int[] sortArrayByParity(int[] A) {
        int[] ans = new int[A.length];
        int cnt = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i]%2 == 0) {
                ans[cnt++] = A[i];
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i]%2 == 1) {
                ans[cnt++] = A[i];
            }
        }
        return ans;
    }
}