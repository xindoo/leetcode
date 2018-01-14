class Solution {
public:
    void wiggleSort(vector<int>& nums) {
        int n = nums.size();
        if (n < 1)
        {
            return;
        }
        sort(nums.begin(), nums.end());

        vector<int> temp(n, 0);
        int j = n-1;
        for (int i = 1; i < n; i += 2, j--)
        {
            temp[i] = nums[j];
        }
        for (int i = 0; i < n; i += 2, j--)
        {
            temp[i] = nums[j];
        }

        nums = temp;
    }
};