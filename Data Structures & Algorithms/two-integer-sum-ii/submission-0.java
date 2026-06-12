class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int[] result = new int[2];
        int numsLength = numbers.length;
        int leftPointer = 0;
        int rightPointer = numsLength-1;

        
        int sumValue = numbers[rightPointer] + numbers[leftPointer];
        while (sumValue != target && leftPointer < rightPointer){
            if (sumValue < target){
                leftPointer++;
            } else {
                rightPointer--;
            }

            sumValue = numbers[leftPointer] + numbers[rightPointer];
        }

        result[0] = leftPointer+1;
        result[1] = rightPointer+1;

        return result;
    }
}