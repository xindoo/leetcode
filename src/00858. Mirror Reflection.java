class Solution {
    private int gcd(int x, int y) {
        if (x%y == 0)
            return y;
        return gcd(y, x%y);
    }

    public int mirrorReflection(int p, int q) {
        if(p==q)
            return 1;
        if(q==0)
            return 0;
        int lcm = p*q/gcd(p, q) ;
        if ((lcm/q) %2 == 1) {
            if ((lcm/p) %2 == 1) {
                return 1;
            } else {
                return 0;
            }
        } else {
            if ((lcm/p ) %2 == 1) {
                return 2;
            } else {
                return 1;
            }
        }
    }
}