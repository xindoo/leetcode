public class Solution {
    private int gcd(int x, int y) {
        if (x%y == 0)
            return y;
        return gcd(y, x%y);
    }
    public boolean canMeasureWater(int x, int y, int z) {
        if (x+y < z)
            return false;
        if (x == 0 || y == 0)
            return x == z || y == z;
        int a = gcd(x, y);
        return z%a == 0;
    }
}