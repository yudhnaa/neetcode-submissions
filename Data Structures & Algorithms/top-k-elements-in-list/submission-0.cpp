class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {

        const int NUMBERS_SIZE = nums.size();

        unordered_map<int,int> freq;
        for (int& num : nums)
        {
            freq[num]++;
        }

        vector<vector<int>> buckets(NUMBERS_SIZE+1);
        for (auto pair : freq)
        {
            buckets[pair.second].push_back(pair.first);
        }

        vector<int> res;
        // loop begin from NUMBERS_SIZE because we have N+1 buckets and sorted from low to high 
        //(freq count is array index for buckets) && (we dont have 0 freq count)
        for (int i = NUMBERS_SIZE; i >=1; i--)
        {
            for (auto num : buckets[i])
            {
                res.push_back(num);

                if (res.size() == k)
                    return res;
            }
        }

        return res;
    }
};
