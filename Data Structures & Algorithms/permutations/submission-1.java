class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        int[] used = new int[nums.length];

        backTrack(
            nums,
            used,
            new ArrayList<>()
        );

        return result;
    }

    private void backTrack(
        int[] nums,
        int[] used,
        List<Integer> currentList
    ) {

        if (currentList.size() == nums.length) {
            result.add(
                new ArrayList<>(currentList)
            );

            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] > 0) {
                continue;
            }

            currentList.add(nums[i]);
            used[i]++;

            backTrack(
                nums,
                used,
                currentList
            );

            currentList.remove(
                currentList.size() - 1
            );
            used[i]--;
        }
    }
}
