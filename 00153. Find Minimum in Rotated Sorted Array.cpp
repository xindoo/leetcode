class Solution {
public:
    int findMin(vector<int> &num) {
        int minval = 0x3f3f3f3f;
        int len = num.size();
        for (int i = 0; i < len; i++) {
            minval = min(minval, num[i]);
        }
        return minval;
    }
};