class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxRectangle = -1;

        for (int i = 0; i < heights.length; i++){
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                int topHeightIndex = stack.pop();

                int leftBoundary = stack.isEmpty() ? 0 : stack.peek()+1;
                int rectangle = heights[topHeightIndex]*(i-leftBoundary);

                maxRectangle = Math.max(maxRectangle, rectangle);

                System.out.println(i);
                System.out.println(leftBoundary);
                System.out.println(heights[topHeightIndex]);
                System.out.println(maxRectangle+"\n\n");
            }

            stack.push(i);
        }

        while (!stack.isEmpty()){
            int topHeightIndex = stack.pop();
            
            int leftBoundary = stack.isEmpty() ? 0 : stack.peek()+1;
            int rectangle = heights[topHeightIndex]*(heights.length-leftBoundary);

            maxRectangle = Math.max(maxRectangle, rectangle);
        }

        return maxRectangle;
    }
}
