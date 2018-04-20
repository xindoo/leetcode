class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor==-1 || divisor == 0)
            return Integer.MAX_VALUE;
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        long ans = 0;
        while (a >= b) {
            long t = b;
            long m = 1;
            while (a > (t<<1)) {
                t = t<<1;
                m <<= 1;
            }
            a -= t;
            ans += m;
        }
        if (dividend<0&& divisor>0 || dividend>0&&divisor<0)
            return (int)-ans;
        return (int)ans;
    }
}
