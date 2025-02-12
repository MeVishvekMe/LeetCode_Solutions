class Solution {
    public int maximumSum(int[] nums) {
        // Array to store the maximum number for each possible sum of digits (0 to 81)
        int[] max = new int[82];

        // Variable to store the maximum sum of two numbers having the same digit sum
        int result = -1;

        // Iterate through each number in the input array
        for (int i : nums) {
            int currentNum = i;  // Store the current number
            int currentDigitsSum = 0;  // Variable to store the sum of digits of the current number

            // Compute the sum of the digits of the current number
            while (currentNum != 0) {
                currentDigitsSum += currentNum % 10;  // Extract the last digit and add it to the sum
                currentNum /= 10;  // Remove the last digit from the number
            }

            // If there is already a number with the same digit sum, update the result
            if (max[currentDigitsSum] > 0) {
                result = Math.max(result, max[currentDigitsSum] + i);
            }

            // Update the maximum number found for this digit sum
            max[currentDigitsSum] = Math.max(i, max[currentDigitsSum]);
        }

        // Return the maximum sum found, or -1 if no such pair exists
        return result;
    }
}
