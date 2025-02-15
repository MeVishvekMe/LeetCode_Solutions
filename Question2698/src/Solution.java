class Solution {
    public int punishmentNumber(int n) {
        int punishmentNumber = 0;

        // Iterate through all numbers from 1 to n
        for(int i = 1; i <= n; i++) {
            int squared = i * i; // Compute the square of the current number

            // Check if the squared number can be split into parts summing to 'i'
            if(checkNum(squared, i)) {
                punishmentNumber += squared; // Add to the total punishment number if condition is met
            }
        }
        return punishmentNumber; // Return the final computed punishment number
    }
    
    public boolean checkNum(int num, int target) {
        // Base case: if target becomes negative or num is too small, return false
        if(target < 0 || num < target) {
            return false;
        }

        // If num exactly matches the target, return true
        if(num == target) {
            return true;
        }

        // Recursively check by splitting num into different parts
        return checkNum(num / 10, target - (num % 10)) ||  // Remove last digit
                checkNum(num / 100, target - (num % 100)) || // Remove last two digits
                checkNum(num / 1000, target - (num % 1000)); // Remove last three digits
    }
}
