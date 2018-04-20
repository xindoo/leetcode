class Solution {
public:
    int maxProfit(vector<int> &prices) {
        int len = prices.size();
        if (0 == len)
             return 0;
        int maxP = 0;
        int low = prices[0];
        for (int i = 0; i < len-1; i++) {
            if (prices[i+1] < prices[i]) {
                maxP += (prices[i]-low);
                low = prices[i+1];
            }
        }
        if (prices[len-1] > low)
            maxP += (prices[len-1]-low);
        return maxP;
    }
};
