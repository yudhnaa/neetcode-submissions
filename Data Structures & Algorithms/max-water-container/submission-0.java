class Solution {
    public int maxArea(int[] heights) {
        
        int heightLength = heights.length;
        int maxContainer = 0;

        int leftP = 0;
        int rightP = heightLength - 1;

        while (leftP < rightP){
            int minHeight = heights[leftP] < heights[rightP] ? heights[leftP] : heights[rightP];
            int container = (rightP-leftP) * minHeight;

            maxContainer = container > maxContainer ? container : maxContainer;

            if (minHeight == heights[leftP]){
                leftP++;
            } else {
                rightP--;
            }
        }

        return maxContainer;
    }
}
