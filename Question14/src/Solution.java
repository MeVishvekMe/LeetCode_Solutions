class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Edge case: If the input array is null or empty, return an empty string
        if (strs == null || strs.length == 0) return "";

        StringBuilder sb = new StringBuilder(); // To store the longest common prefix
        int currentIndex = 0; // Keeps track of the character index we are checking

        // Iterate through each character position in the first string
        while (currentIndex < strs[0].length()) {
            char currentChar = strs[0].charAt(currentIndex); // Get the character from the first string

            // Compare the current character with corresponding characters in all strings
            for (int i = 0; i < strs.length; i++) {
                // Check if the current index exceeds the string length (to avoid index out of bounds)
                // OR if the character doesn't match the one in the first string
                if (currentIndex >= strs[i].length() || strs[i].charAt(currentIndex) != currentChar) {
                    return sb.toString(); // Return the common prefix found so far
                }
            }

            sb.append(currentChar); // Append the common character to the result
            currentIndex++; // Move to the next character index
        }

        return sb.toString(); // Return the final longest common prefix
    }
}
