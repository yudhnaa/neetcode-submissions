class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int stringLength = s.length();
        if (stringLength == 1){
            return stringLength;
        }

        char[] charArray = s.toCharArray();
        int longestSubStringLength = 0;
        int leftPointer = 0;
        int rightPointer = leftPointer+1;

        while(leftPointer < stringLength){
            Set<Character> existChar = new HashSet<>();

            while (rightPointer < stringLength){
                existChar.add(charArray[leftPointer]);

                if (existChar.contains(charArray[rightPointer])){
                    break;
                }
                existChar.add(charArray[rightPointer]);
                rightPointer++;
            }
            longestSubStringLength = longestSubStringLength < (rightPointer - leftPointer) ? (rightPointer - leftPointer) : longestSubStringLength;
            leftPointer++;
            rightPointer = leftPointer+1;

        }

        return longestSubStringLength;
    }
}
