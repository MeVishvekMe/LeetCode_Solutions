class Solution {
    public int countArrays(int[] original, int[][] bounds) {
        int n = original.length;  // Get the length of the original array

        // Initialize the range of possible values for the first element
        int low = bounds[0][0], high = bounds[0][1];

        // Iterate through the array to update the range based on differences
        for (int i = 1; i < n; i++) {
            int diff = original[i] - original[i - 1];  // Compute the difference between adjacent elements

            // Update the lower bound: it must be within the given range and maintain the difference
            low = Math.max(bounds[i][0], low + diff);

            // Update the upper bound: it must be within the given range and maintain the difference
            high = Math.min(bounds[i][1], high + diff);

            // If the lower bound exceeds the upper bound, it's impossible to form a valid sequence
            if (low > high) {
                return 0;
            }
        }

        // Return the count of possible values for the last element
        return high - low + 1;
    }
}