class Solution {
    public int trap(int[] height) {
        int heightLength = height.length;

        int leftP = 0;
        int rightP = heightLength-1;

        int maxLeft = height[leftP];
        int maxRight = height[rightP];
        int water = 0;

        while (leftP < rightP){
            if (maxLeft <= maxRight){
                water += maxLeft - height[leftP];
                leftP++;
                maxLeft = height[leftP] > maxLeft ? height[leftP] : maxLeft;
            } else {
                water += maxRight - height[rightP];                
                rightP--;
                maxRight = height[rightP] > maxRight ? height[rightP] : maxRight;
            }
        }

        return water;
    }
}