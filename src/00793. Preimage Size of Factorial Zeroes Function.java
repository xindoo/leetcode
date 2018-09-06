class Solution {
    public int preimageSizeFZF(int K) {
        long l = 0;
        long r = Long.MAX_VALUE;
        return (int)(bsearch(l, r, K+1) - bsearch(l, r, K));
    }

    private long bsearch(long l, long r, long v) {
        while (l < r) {
            long mid = (l + r) >> 1;
            if (fact5(mid) < v) {
                l = mid+1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private long fact5(long n) {
        long count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
}