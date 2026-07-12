class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int leftColP = 0;
        int rightColP = rows * cols - 1; // flat matrix

        while(leftColP <= rightColP){
            int middle = leftColP + (rightColP - leftColP) / 2;

            int row = middle / cols; // convert index from flat -> matrix
            int col = middle % cols;
            
            if (matrix[row][col] < target){
                leftColP = middle+1;
            } else if (matrix[row][col] > target){
                rightColP = middle-1;
            } else {
                return true;
            }
        }

        return false;
    }
}
