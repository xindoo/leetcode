class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int start = -1, last = -1, res = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] > R) {
                start = last = i;
                continue;
            }

            if(A[i] >= L)
                last = i;

            res += last - start;
        }
        return res;
    }
}