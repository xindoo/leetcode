class Solution {
public:
    int reverse(int x) {
        int flag = 1;
        if (x < 0) {
            flag = -1;
            x = -x;
        }
        int ans = 0;
        while (x) {
            ans *= 10;
            ans += x%10;
            x /= 10;
        }
        return ans*flag;
    }
};