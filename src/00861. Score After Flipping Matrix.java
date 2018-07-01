class Solution {
    public int matrixScore(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < A[i].length; j++) {
                    A[i][j] = A[i][j]^1;
                }
            }
        }
        for (int i = 0; i < A[0].length; i++) {
            int cnt = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j][i] == 0)
                    cnt++;
            }
            if (cnt > A.length/2) {
                for (int j = 0; j < A.length; j++) {
                    A[j][i] ^= 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            int num = 1;
            for (int j = A[0].length-1; j >= 0; j--) {
                if (A[i][j] == 1)
                    ans += num;
                num *= 2;
            }
        }
        return  ans;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.matrixScore(new int[][]{{0,0,1,1},{1,0,1,0},{1,1,0,0}});
    }
}