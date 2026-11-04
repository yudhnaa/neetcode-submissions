class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();

        Arrays.sort(nums);

        subSetII(
            nums,
            0,
            new ArrayList<>()
        );

        return result;    
    }

    private void subSetII(
        int[] nums,
        int startIndex,
        List<Integer> currentList
    ) {

        this.result.add(new ArrayList<>(currentList));
        
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i-1]) {
                continue;
            }

            currentList.add(nums[i]); 

            subSetII(
                nums,
                i+1,
                currentList
            );

            currentList.remove(
                currentList.size() - 1
            );
        }

    }
}
