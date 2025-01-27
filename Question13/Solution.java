public class Solution {
    public int romanToInt(String s) {
        int result = 0; // Initialize the result to store the final integer value

        // Iterate through each character in the string
        for(int i = 0; i < s.length(); i++) {
            // Check if the current character is followed by another character and if the next character's value is greater
            if(i + 1 < s.length() && givNum(s.charAt(i + 1)) > givNum(s.charAt(i))) {
                // If the next character's value is greater, subtract the current character's value from the result
                result -= givNum(s.charAt(i));
            }
            else {
                // Otherwise, add the current character's value to the result
                result += givNum(s.charAt(i));
            }
        }
        return result; // Return the final computed integer value
    }

    // Helper method to convert a Roman numeral character to its corresponding integer value
    public int givNum (char c) {
        switch (c) {
            case 'I':
                return 1; // I represents 1
            case 'V':
                return 5; // V represents 5
            case 'X':
                return 10; // X represents 10
            case 'L':
                return 50; // L represents 50
            case 'C':
                return 100; // C represents 100
            case 'D':
                return 500; // D represents 500
            case 'M':
                return 1000; // M represents 1000
            default:
                return 0; // Default case for any unexpected character
        }
    }
}