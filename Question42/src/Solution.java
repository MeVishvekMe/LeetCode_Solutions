public class Solution {
    public int trap(int[] height) {
        // Get the length of the height array
        int n = height.length;

        // Variables to keep track of the maximum heights from the left and right
        int maxL = 0;
        int maxR = 0;

        // Arrays to store the maximum height to the left and right of each index
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        // Populate maxLeft and maxRight arrays
        for (int i = 0; i < n; i++) {
            // maxLeft[i] contains the maximum height to the left of index i (excluding i itself)
            maxLeft[i] = maxL;

            // maxRight[n - 1 - i] contains the maximum height to the right of index (n - 1 - i) (excluding that index itself)
            maxRight[n - 1 - i] = maxR;

            // Update maxL and maxR to include the current height values
            maxL = Math.max(height[i], maxL);
            maxR = Math.max(height[n - 1 - i], maxR);
        }

        // Variable to accumulate the total trapped water
        int totalWater = 0;

        // Calculate the trapped water for each index
        for (int i = 0; i < n; i++) {
            // The water that can be trapped at index i is the minimum of maxLeft and maxRight minus the height at i
            int calculated = Math.min(maxLeft[i], maxRight[i]) - height[i];

            // Only add to total water if the calculated water is positive
            if (calculated > 0) {
                totalWater += calculated;
            }
        }

        // Return the total amount of trapped water
        return totalWater;
    }
}
