public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // If s1 is longer than s2, it's impossible for s1 to be a permutation of any substring in s2
        if (s1.length() > s2.length()) {
            return false;
        }

        // Frequency arrays to count occurrences of characters in s1 and the current window in s2
        int[] s1Freq = new int[26]; // Frequency of characters in s1
        int[] windowFreq = new int[26]; // Frequency of characters in the current window of s2

        // Initialize the frequency arrays for s1 and the first window in s2
        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++; // Increment count for each character in s1
            windowFreq[s2.charAt(i) - 'a']++; // Increment count for each character in the first window of s2
        }

        // Count the number of matching frequencies between s1Freq and windowFreq
        int matches = 0; // Number of matching characters between the two frequency arrays
        for (int i = 0; i < 26; i++) {
            if (s1Freq[i] == windowFreq[i]) {
                matches++; // Increment matches for characters that have the same frequency
            }
        }

        // Sliding window approach to check all substrings of length s1.length() in s2
        int left = 0; // Left pointer of the window
        for (int right = s1.length(); right < s2.length(); right++) {
            // If all 26 characters have matching frequencies, we found a valid permutation
            if (matches == 26) {
                return true;
            }

            // Remove the character at the `left` pointer from the window
            int leftCharIndex = s2.charAt(left) - 'a';
            if (s1Freq[leftCharIndex] == windowFreq[leftCharIndex]) {
                matches--; // Decrement matches if the frequencies were matching
            }
            windowFreq[leftCharIndex]--; // Decrease the frequency of the character leaving the window
            if (s1Freq[leftCharIndex] == windowFreq[leftCharIndex]) {
                matches++; // Increment matches if the frequencies match again
            }

            // Add the character at the `right` pointer to the window
            int rightCharIndex = s2.charAt(right) - 'a';
            if (s1Freq[rightCharIndex] == windowFreq[rightCharIndex]) {
                matches--; // Decrement matches if the frequencies were matching
            }
            windowFreq[rightCharIndex]++; // Increase the frequency of the character entering the window
            if (s1Freq[rightCharIndex] == windowFreq[rightCharIndex]) {
                matches++; // Increment matches if the frequencies match again
            }

            // Move the `left` pointer forward
            left++;
        }

        // Check the final window for a valid permutation
        return matches == 26;
    }

    public boolean checkInclusionMyApproach(String s1, String s2) {
        // Array to keep track of character frequencies in s1
        int[] track = new int[26];

        // Populate the frequency array with characters from s1
        for (int i = 0; i < s1.length(); i++) {
            track[s1.charAt(i) - 'a']++;
        }

        int left = 0; // Initialize the left pointer of the window

        // Iterate through s2 with the left pointer
        while (left < s2.length()) {
            // Check if the current character at 'left' is in s1
            if (track[s2.charAt(left) - 'a'] > 0) {
                int right = left; // Initialize the right pointer of the window

                // Expand the window with the right pointer
                while (left <= right && right < s2.length()) {
                    // If the character at 'right' is not in s1 or overused in the current window
                    if (track[s2.charAt(right) - 'a'] == 0) {
                        // If left equals right, it means we cannot form a valid window here
                        if (left == right) {
                            break; // Break out of the inner loop
                        }

                        // Adjust the left pointer to shrink the window and restore track[]
                        track[s2.charAt(left) - 'a']++;
                        left++;
                        continue; // Skip further checks and reevaluate
                    }

                    // Check if the current window matches the size of s1
                    if (right - left + 1 == s1.length()) {
                        return true; // A valid permutation of s1 is found in s2
                    }

                    // Decrease the frequency of the current character and expand the window
                    track[s2.charAt(right) - 'a']--;
                    right++;
                }
            }

            // Move the left pointer to explore the next potential window
            left++;
        }

        return false; // No valid permutation of s1 was found in s2
    }
}
