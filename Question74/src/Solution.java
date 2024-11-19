class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Compute rows and columns
        int rows = matrix.length;
        int columns = matrix[0].length;

        // Set left and right pointers to the start and end
        int left = 0;
        int right = rows * columns - 1;

        // Binary search loop condition
        while(left <= right) {

            // Calculating midIndex taking overflow into consideration
            int midIndex = left + (right - left) / 2;

            // Converting 1D index to 2D index
            int midNumber = matrix[midIndex / columns][midIndex % columns];

            // Basic binary search conditions
            if(midNumber == target) {
                return true;
            }
            else if(midNumber > target) {
                right = midIndex - 1;
            }
            else {
                left = midIndex + 1;
            }
        }
        return false;
    }
}