class Solution {
    public int longestMountain(int[] A) {
        int ascCount = 0;
        int desCount = 0;
        int res = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i-1]) {
                if (desCount != 0) {
                    desCount = 0;
                    ascCount = 0;
                }
                ascCount++;
            } else if (A[i] < A[i-1]) {
                desCount++;
            } else {
                ascCount = 0;
                desCount = 0;
            }
            if (desCount > 0 && ascCount > 0) {
                res = Math.max(res, ascCount + desCount + 1);
            }
        }
        return res > 2 ? res : 0;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestMountain(new int[]{1,2,0,2,0,2}));
    }
}