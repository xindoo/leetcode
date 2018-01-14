class Solution {
public:
    vector<int> getRow(int rowIndex) {
        vector<int> v;
        for (int i = 0; i <= rowIndex; i++) {
            int len = v.size();
            for (int j = len-1; j >= 1; j--)
                v[j] += v[j-1];
            v.push_back(1);
        }
        return v; 
    }
};