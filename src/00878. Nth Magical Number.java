class Solution {
    private long gcd(long x, long y) {
        if (x%y == 0)
            return y;
        return gcd(y, x%y);
    }
    public int nthMagicalNumber(int N, int A, int B) {
        long C = 1l*A*B/gcd(A, B);
        long r = 1000000000l*40000*40000;
        long l = 0;
        while(l < r) {
            long mid = (l+r)/2;
            long cnt = mid/A + mid/B - mid/C;
            if (cnt < N)
                l = mid+1;
            else
                r = mid;
        }
        return (int) (l%1000000007);
    }
}