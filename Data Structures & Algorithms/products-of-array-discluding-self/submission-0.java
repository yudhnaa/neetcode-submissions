class Solution {
    public int[] productExceptSelf(int[] nums) {
        int numsLength = nums.length;
        int[] answer = new int[numsLength];

        int prefixProduct = 1;
        for (int i = 0; i < numsLength; i++){
            answer[i] = prefixProduct;
            prefixProduct *= nums[i];
        }

        int suffixProduct = 1;
        for (int i = numsLength-1; i > -1; i--){
            answer[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return answer;
    }
}