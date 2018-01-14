/*
 *不会做,看了别人的代码,终于想清楚什么个思路了
 *其实就是通过比较A[as] B[bs]的大小来决定as或者bs增大或减小，有个前提条件，as+bs==k, 所以
 *as增大bs必然减小，反之亦然，代码里好多if判断，其实是为了处理数组边界。
 */
class Solution {
    private int getkth(int[] A, int as, int[] B, int bs, int k) {
        if (as > A.length - 1) return B[bs + k - 1];
        if (bs > B.length - 1) return A[as + k - 1];
        if (k == 1) return Math.min(A[as], B[bs]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (as + k/2 - 1 < A.length) aMid = A[as + k/2 - 1];
        if (bs + k/2 - 1 < B.length) bMid = B[bs + k/2 - 1];

        if (aMid < bMid)
            return getkth(A, as + k/2, B, bs, k - k/2);
        else
            return getkth(A, as, B, bs + k/2, k - k/2);
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (getkth(nums1, 0, nums2, 0, l) + getkth(nums1, 0, nums2, 0, r)) / 2.0;
    }
}