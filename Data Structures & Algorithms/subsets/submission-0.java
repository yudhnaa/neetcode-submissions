class Solution {
    private List<List<Integer>> result;
    
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        result.add(new ArrayList<>());

        backtrack(nums, new ArrayList<>(), 0);
        
        return result;
    }

    public void backtrack(int[] nums, List<Integer> current, int startIndex){


        for (int i = startIndex; i < nums.length; i++){
            current.add(nums[i]);
            
            this.result.add(new ArrayList<>(current));

            backtrack(nums, current, i+1);

            current.remove(current.size()-1);

        }
        
    }
}
