class Solution {
public:
    bool isPowerOfFour(int num) {
        int a = 0x55555555;
        if ((num & a) != 0 && (num&(num-1)) == 0)
            return true ;
        return false;
    }
};