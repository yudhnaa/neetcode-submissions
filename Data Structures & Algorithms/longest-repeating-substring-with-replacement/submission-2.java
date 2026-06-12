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
            
            // Ở đây ta không cập nhật maxFreq và giữ "ảo tưởng" về một window có size bằng với maxFreq lớn nhất trong lịch sử.
            // Vì: việc leftP++ làm cho window nhỏ hơn thì new_maxFreq sẽ <= current_maxFreq -> Không thể xuất hiện được 1 chuỗi dài hơn.
            // Do đó: Ta giữ "ảo tưởng" răng window hiện tại là hợp lý cho đến khi rightP tăng đến 1 ngưỡng làm cho new_maxFreq >= current_maxFreq -> Có thể xuất hiện 1 substring lớn hơn
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
