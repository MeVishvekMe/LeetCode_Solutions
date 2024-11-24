class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int i = 0;
        int min = Integer.MAX_VALUE;
        int negatives = 0; // Variable to calculate number of negatives
        long sum = 0; // Variable for calculating sum
        while(i < matrix.length) {
            int j = 0;
            while(j < matrix[i].length) {
                // Abs variable
                int num = Math.abs(matrix[i][j]);

                // Adding current element to sum
                sum += num;

                // Increase the count of negatives if found
                if(matrix[i][j] < 0) {
                    negatives++;
                }

                // Update the minimum element
                min = Math.min(min, num);
                j++;
            }
            i++;
        }

        // If negatives are even, just return the sum or else subtract 2*min
        return (negatives % 2 == 0) ? sum : sum - (2L * min);
    }
}