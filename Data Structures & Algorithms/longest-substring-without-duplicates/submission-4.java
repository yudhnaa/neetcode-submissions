class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int stringLength = s.length();
        if (stringLength == 1){
            return stringLength;
        }

        Set<Character> charSet = new HashSet<>();
        int longestSubStringLength = 0;
        
        int leftPointer = 0;

        for (int rightPointer = 0; rightPointer < stringLength; rightPointer++) {
            
            while (charSet.contains(s.charAt(rightPointer))) {
                charSet.remove(s.charAt(leftPointer));
                leftPointer++;
            }

            charSet.add(s.charAt(rightPointer));
            longestSubStringLength = Math.max(
                longestSubStringLength,
                rightPointer - leftPointer + 1
            );
        }

        return longestSubStringLength;
    }
}
