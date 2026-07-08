class Solution {
    public int search(int[] nums, int target) {
        
        int leftP = 0;
        int rightP = nums.length - 1;
        while (leftP <= rightP){
            int middleIndex = leftP + (rightP-leftP)/2;

            if (nums[middleIndex] > target){
                rightP = middleIndex-1;
            } else if (nums[middleIndex] < target){
                leftP = middleIndex+1;
            } else {
                return middleIndex;
            }
        }
        
        return -1;
    }
}
