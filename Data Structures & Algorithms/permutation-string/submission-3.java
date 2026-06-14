class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();
        
        if (s1Length > s2Length){
            return false;
        }

        int[] countS1 = new int[26];
        int[] countS2 = new int[26];
        

        for (int i = 0; i < s1Length; i++){
            countS1[s1.charAt(i)-'a']++;
            countS2[s2.charAt(i)-'a']++;
        }

        if (matches(countS1, countS2)){
            return true;
        }

        for (int i = s1Length; i < s2Length; i++){
            countS2[s2.charAt(i)-'a']++;
            countS2[s2.charAt(i-s1Length)-'a']--;

            if (matches(countS1, countS2)){
                return true;
            }
        }

        return false;
    }

    private boolean matches(int[] countS1, int[] countS2){
        for (int i = 0; i < 26; i++){
            if (countS1[i] != countS2[i]){
                return false;
            }
        }

        return true;
    }
}
