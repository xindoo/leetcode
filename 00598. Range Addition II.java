class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int[] maxval = new int[]{m,n};
        for (int i = 0; i < ops.length; i++) {
            maxval[0] = Math.min(maxval[0], ops[i][0]);
            maxval[1] = Math.min(maxval[1], ops[i][1]);
        }
        return maxval[0]*maxval[1];
    }
}