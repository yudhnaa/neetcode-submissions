class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        
        unordered_map<string, vector<string>> hashMap;
        for (string &s : strs){

            int countChar[26] = {0};

            // count chars in string and save it to an array
            // eg: [0,1,0,...,0,0,1]
            for (int i = 0; i < s.length(); i++){
                countChar[s[i] - 'a']++;
            }

            // convert count array to string for using as key in hashMap
            string hashKey = to_string(countChar[0]);

            for (int i = 1; i < 26; i++){
                hashKey += "#" + to_string(countChar[i]);
            }

            // insert string in to hashMap base on hashKey
           hashMap[hashKey].push_back(s);
        }

        // take result from hashMap
        vector<vector<string>> result;
        for (auto &pair : hashMap){
            result.push_back(pair.second);
        }

        return result;

    }
};
