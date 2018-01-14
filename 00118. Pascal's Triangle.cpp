class Solution {
public:
    vector<vector<int> > generate(int numRows) {
        vector<vector<int> > ans;
        if (numRows == 0)
            return ans;
        for (int i = 0; i < numRows; i++) {
            vector<int> v;
            v.push_back(1);
            if (0 != i) {
                int len = i-1;
                for (int j = 1; j <= len; j++) {
                    v.push_back(ans[i-1][j-1] + ans[i-1][j]);
                }
                v.push_back(1);
            }
            ans.push_back(v);
        }
        return ans;
    }
};