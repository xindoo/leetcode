class Solution {
    public int hammingDistance(int x, int y) {
        int a = x^y;
        int res = 0;
        while (a != 0) {
            a = (a&(a-1));
            res++;
        }
        return res;
    }
}