class Solution {
public:  
    struct newnode {
        int val;
        int pos;
        bool operator < (newnode y) const {
            return val < y.val;
        }
    };
    int BinarySearch(vector<newnode> &numbers, int l, int r, int val) {
        if (l == r) {
            if (numbers[l].val == val)
                return l;
            return 0;
        }
        int mid = (l+r)>>1;
        if (val <= numbers[mid].val)
            return BinarySearch(numbers, l, mid, val);
        else 
            return BinarySearch(numbers, mid+1, r, val);
    }
    vector<int> twoSum(vector<int> &numbers, int target) {
        int n = numbers.size();       
        vector<newnode> sor;
        for (int i = 0; i < n; i++) {
            newnode t;
            t.val = numbers[i];
            t.pos = i+1;
            sor.push_back(t);
        }
        sort(sor.begin(), sor.end());
        vector<int> ans;
        ans.push_back(0);
        ans.push_back(0);
        for (int i = 0; i < n-1; i++) {
            ans[0] = sor[i].pos;
            int x = BinarySearch(sor, i+1, n-1, target-sor[i].val);
            if (x) {
                ans[1] = sor[x].pos;
                if (ans[0] > ans[1])
                    swap(ans[0], ans[1]);
                break;
            }
        }
        return ans;
    }
};
