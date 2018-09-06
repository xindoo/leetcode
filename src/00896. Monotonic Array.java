class Solution {
    public boolean isMonotonic(int[] A) {
        if (null == A || A.length == 0) {
            return false;
        }
        if (A.length == 1) {
            return true;
        }
        boolean a  = true;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i-1]) {
                a = false;
            }
        }
        if (a) {
            return true;
        }
        a = true;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i-1]) {
                a = false;
            }
        }
        if (a) {
            return true;
        }
        return false;
    }
}