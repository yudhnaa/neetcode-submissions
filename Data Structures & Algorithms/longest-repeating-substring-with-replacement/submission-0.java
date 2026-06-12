class Solution {
    public int characterReplacement(String s, int k) {

        int stringLength = s.length();
        if (stringLength == 1){
            return 1;
        }

        int[] count = new int[26];
        int maxFreq = 0;
        int leftP = 0;
        int longestStringLength = 0;

        for (int rightP = 0; rightP < stringLength; rightP++){

            count[s.charAt(rightP)-'A']++;
            maxFreq = Math.max(
                maxFreq,
                count[s.charAt(rightP)-'A']
            );
            
            while((rightP-leftP+1) - maxFreq > k){
                count[s.charAt(leftP)-'A']--;
                leftP++;
            }

            longestStringLength = Math.max(
                longestStringLength,
                rightP-leftP+1
            );

        }

        return longestStringLength;
    }
}
