class Solution {
    public int lengthOfLongestSubstring(String s) {
        int stringLength = s.length();
        if (stringLength == 1){
            return 1;
        }

        Set<Character> charSet = new HashSet<>();
        int longestSubStringLength = 0;

        int leftP = 0;

        for (int rightP = 0; rightP < stringLength; rightP++){
            while (charSet.contains(s.charAt(rightP))){
                charSet.remove(s.charAt(leftP));
                leftP++;
            }

            charSet.add(s.charAt(rightP));
            longestSubStringLength = Math.max(
                longestSubStringLength,
                rightP-leftP + 1
            );
        }

        return longestSubStringLength;
    }
}