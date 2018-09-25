class Solution {
    public int smallestRangeI(int[] A, int K) {
        int max = -1;
        int min = 100000;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[i]);
        }
        if (max - min <= K*2) {
            return 0;
        }
        return max - min - 2*K;
    }
}