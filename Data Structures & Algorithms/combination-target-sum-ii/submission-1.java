class Solution {

    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();

        Arrays.sort(candidates);

        backTrack(
            candidates,
            target,
            0,
            new ArrayList<>()
        );

        return result;
    }

    private void backTrack(
        int[] candidates,
        int remain,
        int startIndex,
        List<Integer> currentList
    ) {

        if (remain == 0) {
            this.result.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (i > startIndex && candidates[i] == candidates[i-1]
            ) {
                continue;
            }

            if (candidates[i] > remain) {
                break;
            }

            currentList.add(candidates[i]);

            backTrack(
                candidates,
                remain - candidates[i],
                i + 1,
                currentList
            );

            currentList.remove(
                currentList.size() - 1
            );
        }

    }
}
