class Solution {
public:
    bool hasDuplicate(vector<int>& nums) {
        unordered_set<int> seen = unordered_set<int>(nums.begin(), nums.end());

        return seen.size() < nums.size();

    }
};