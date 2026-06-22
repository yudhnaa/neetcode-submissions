class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;

        while (nums[i] > -1){
            int next = nums[i];
            nums[i] = -1;
            i = next;
        }

        return i;
    }
}
