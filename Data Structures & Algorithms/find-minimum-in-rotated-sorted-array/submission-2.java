class Solution {
    public int findMin(int[] nums) {
       
       int left = 0;
       int right = nums.length-1;
       int min = nums[0];

       while (left <= right){
            int middle = left+(right-left)/2;

            if (nums[middle] > nums[right]){
                left = middle+1;
            } else {
                min = Math.min(min, nums[middle]);
                right = middle - 1;
            }
       }

       return min;
    }
}
