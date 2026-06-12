class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int left = 0, right = 1;
        int profit = 0;

        while (right < prices.size()){
            if (prices[right] >= prices[left]){
                int res = prices[right] - prices[left];
                profit = max(res, profit);
            } else{
                left = right;
            }
            ++right;
        }

        return profit;
    }
};
