class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int left = 0, right = 1;

        int maxProfit = 0;
        int res = 0;

        while(right < prices.size()){
            if (prices[left] < prices[right]){
                res = prices[right] - prices[left];
                maxProfit = max(maxProfit, res);
            }
            else{
                left = right;
            }

            ++right;
        }

        return maxProfit;
    }
};
