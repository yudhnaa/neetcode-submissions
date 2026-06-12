class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList();

        if (nums == null || nums.length < 3) {
            return result;
        }

        int TARGET = 0;

        Arrays.sort(nums);
        int numsLength = nums.length;
        
        for (int i = 0; i < numsLength; i++){
            
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            int fixedPointer = i;
            int leftPointer = fixedPointer + 1;
            int rightPointer = numsLength - 1;
            
            System.out.println(fixedPointer + "-" + leftPointer + "-" + rightPointer);
            
            while (leftPointer < rightPointer){
                int sum = nums[fixedPointer] + nums[leftPointer] + nums[rightPointer];
                
                if (sum == TARGET ){
                    List<Integer> triplet = new ArrayList(Arrays.asList(
                        nums[fixedPointer],
                        nums[leftPointer],
                        nums[rightPointer]
                    ));

                    result.add(triplet);

                    while (leftPointer < rightPointer && nums[leftPointer] == nums[leftPointer + 1]) {
                        leftPointer++;
                    }

                    while (leftPointer < rightPointer && nums[rightPointer] == nums[rightPointer - 1]) {
                        rightPointer--;
                    }

                    leftPointer++;
                    rightPointer--;

                } else {
                    if (sum < TARGET){
                        leftPointer++;
                    } else {
                        rightPointer--;
                    }
                }
            }
        }

        return result;
    }
}