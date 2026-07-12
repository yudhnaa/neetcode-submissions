class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = 0;
        while (row < matrix.length-1 && matrix[row+1][0] <= target){
            row++;
        }

        int leftColP = 0;
        int rightColP = matrix[row].length-1;

        while(leftColP <= rightColP){
            int middleCol = leftColP + (rightColP-leftColP)/2;
            
            if (matrix[row][middleCol] < target){
                leftColP = middleCol+1;
            } else if (matrix[row][middleCol] > target){
                rightColP = middleCol-1;
            } else {
                return true;
            }
        }

        return false;
    }
}
