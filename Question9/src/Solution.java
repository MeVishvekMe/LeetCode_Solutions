class Solution {
    public boolean isPalindrome(int x) {
        // Check if number is negative, if negative then it's not palindrome.
        if(x < 0) {
            return false;
        }

        // Store originalNumber is other variable as for comparison with reversed number.
        int originalNumber = x;

        // Initialize reversedNumber with 0
        int reversedNumber = 0;

        // Iterate x, keep dividing it with 10 to eliminate the ones pos every iteration.
        while(x != 0) {
            // Store the ones position multiplying the current reversedNumber and then adding it.
            reversedNumber *= 10;
            reversedNumber += (x % 10);

            x /= 10;
        }

        // Compare originalNumber and originalNumber
        return originalNumber == reversedNumber;
    }
}