class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<Integer>();
        int maxLength = 0;

        for (int num : nums){
            numsSet.add(num);
        }

        for (int num : numsSet){
            boolean isStartNum = !numsSet.contains(num-1);

            if (isStartNum){
                int currentNum = num;
                int length = 0;

                while(numsSet.contains(currentNum)){
                    currentNum++;
                    length++;
                }

                maxLength = maxLength < length ? length : maxLength;
            }
        }

        return maxLength;
    }
}