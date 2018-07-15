class Solution {
    public int[][] transpose(int[][] A) {
        if (A == null || A[0] == null)
            return A;
        int[][] B = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                B[j][i] = A[i][j];
            }
        }
        return B;
    }
}