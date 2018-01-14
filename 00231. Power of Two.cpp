class Solution {
public:
    bool isPowerOfTwo(int n) {
        if (n == 0 || -2147483648 == n)
            return false;
        if ((n&(n-1)) == 0)
            return true;
        return false;
    }
};