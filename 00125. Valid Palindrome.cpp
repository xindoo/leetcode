class Solution {
public:
    bool isPalindrome(string s) {
        string t = "";
        int len = s.length();
        for(int i = 0; i < len; i++) {
            if (s[i] <= 'z' && s[i] >= 'a') {
                t += s[i];
            }
            else if (s[i] <= 'Z' && s[i] >= 'A') {
                t += s[i]+32;
            }
            else if (s[i] <= '9' && s[i] >= '0') {
                t += s[i];
            }
        }
        string rt = "";
        for(int i = t.length()-1; i >= 0; i--) {
            rt += t[i];
        }
        return t == rt;
    }
};