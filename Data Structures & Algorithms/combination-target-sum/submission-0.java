class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<>();

        backtrack(nums, target, 0, target, new ArrayList<>());

        return result;
    }

    private void backtrack(
        int[] nums, 
        int target,
        int startIndex, 
        int remain, 
        List<Integer> current
    ){
        
        if (remain == 0){
            this.result.add(new ArrayList<>(current));
            return;
        }

        for (int i = startIndex; i < nums.length; i++){
            if (nums[i] <= remain){
                current.add(nums[i]);

                backtrack(nums, target, i, remain-nums[i], current);

                current.remove(current.size()-1);
            }
        }
    }
}
