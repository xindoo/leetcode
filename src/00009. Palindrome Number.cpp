class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0)
            return false;
        char str[15];
        int cnt = 0;
        while (x) {
            str[cnt++] = x%10;
            x /= 10;
        }
        str[cnt] = '\0';
        cnt--;
        for (int i = 0; i <= cnt>>2; i++){
            if (str[i] != str[cnt-i])
                return false;
        }
        return true;
    }
};