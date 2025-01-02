public class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0; // Left pointer for the sliding window
        int maxFreq = 0; // Tracks the maximum frequency of any character in the current window
        int result = 0; // Stores the length of the longest valid substring
        int[] count = new int[26]; // Array to store the frequency of characters ('A' to 'Z')

        // Iterate through the string using the right pointer
        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right); // Current character at the right pointer
            count[current - 'A']++; // Increment the frequency of the current character
            maxFreq = Math.max(maxFreq, count[current - 'A']); // Update the max frequency in the window

            // Check if the current window size minus maxFreq exceeds k replacements
            while ((right - left + 1) - maxFreq > k) {
                // Shrink the window from the left if it's invalid
                count[s.charAt(left) - 'A']--; // Decrement the frequency of the leftmost character
                left++; // Move the left pointer to the right
            }

            // Update the result with the size of the current valid window
            result = Math.max(result, right - left + 1);
        }

        return result; // Return the length of the longest valid substring
    }
}
