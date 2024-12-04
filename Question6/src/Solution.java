public class Solution {
    public String convert(String s, int numRows) {
        // Edge case: if numRows is 1, the zigzag pattern is equivalent to the original string
        if (numRows == 1) {
            return s;
        }

        // Initialize an array of StringBuilder, one for each row
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder(); // Initialize each row with a StringBuilder
        }

        // Variables for traversing the string and managing the zigzag direction
        int i = 0; // Index for iterating through the input string
        int sbIndex = 0; // Index for the current row in the zigzag pattern
        int numOp = -1; // Direction indicator: -1 for "up" and 1 for "down"

        // Build the zigzag pattern
        while (i < s.length()) {
            // Append the current character to the current row's StringBuilder
            sb[sbIndex].append(s.charAt(i));

            // Change direction when reaching the top or bottom of the zigzag
            if (sbIndex == 0 || sbIndex == numRows - 1) {
                numOp = -numOp; // Reverse the direction
            }

            // Move to the next row based on the current direction
            sbIndex += numOp;
            i++;
        }

        // Combine all rows into a single StringBuilder for the final result
        StringBuilder resultSb = new StringBuilder();
        i = 0;
        while (i < sb.length) {
            resultSb.append(sb[i]); // Append each row's content to the final result
            i++;
        }

        // Convert the final StringBuilder to a string and return it
        return resultSb.toString();
    }
}
