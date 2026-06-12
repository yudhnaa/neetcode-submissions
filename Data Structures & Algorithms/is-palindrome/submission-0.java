class Solution {
    public boolean isPalindrome(String s) {
        int leftPointer = 0;
        int rightPointer = s.length()-1;

        while (leftPointer < rightPointer){
            boolean isAlphalNumberLeft = Character.isLetterOrDigit(s.charAt(leftPointer));
            boolean isAlphalNumberRight = Character.isLetterOrDigit(s.charAt(rightPointer));
            
            while (!isAlphalNumberLeft && leftPointer < rightPointer ){
                leftPointer++;
                isAlphalNumberLeft = Character.isLetterOrDigit(s.charAt(leftPointer));
            }
            
            while (!isAlphalNumberRight && leftPointer < rightPointer ){
                rightPointer--;
                isAlphalNumberRight = Character.isLetterOrDigit(s.charAt(rightPointer));
            }

            char leftChar = s.charAt(leftPointer);
            char rightChar = s.charAt(rightPointer);

            if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)){
                return false;
            }

            leftPointer++;
            rightPointer--;
        }

        return true;
    }
}