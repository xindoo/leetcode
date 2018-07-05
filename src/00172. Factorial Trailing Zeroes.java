public class Solution {
    public int trailingZeroes(int n) {
        if (n < 25) 
            return n / 5;
        int cnt = n / 5;
        return cnt + trailingZeroes(cnt);
    }
}