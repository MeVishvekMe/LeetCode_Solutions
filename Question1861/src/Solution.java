public class Solution {
    public char[][] rotateTheBox(char[][] box) {
        // Step 1: Settle the rocks in the box
        int itr = 0; // Iterator for rows
        while (itr < box.length) {
            int surface = box[itr].length - 1; // The next available position for a rock to settle
            int rocks = box[itr].length - 1;   // Current position being checked

            // Traverse the row from right to left
            while (rocks >= 0 && surface >= 0) {
                if (box[itr][rocks] == '#') {
                    // If it's a rock ('#'), move it to the next available position
                    box[itr][rocks] = '.';       // Clear the current position
                    box[itr][surface--] = '#';  // Move the rock to the surface and update surface pointer
                } else if (box[itr][rocks] == '*') {
                    // If it's an obstacle ('*'), reset the surface pointer to the position before the obstacle
                    surface = rocks - 1;
                }
                rocks--; // Move to the next position to the left
            }
            itr++; // Move to the next row
        }

        // Step 2: Rotate the box 90 degrees clockwise
        char[][] resultBox = new char[box[0].length][box.length]; // Create a new rotated box with swapped dimensions
        int i = box.length - 1; // Start from the last row of the original box
        int j = 0;

        // Traverse the original box and populate the rotated box
        while (i >= 0) { // Iterate through rows from bottom to top
            j = 0;
            while (j < box[0].length) { // Iterate through columns left to right
                resultBox[j][box.length - 1 - i] = box[i][j]; // Rotate: row becomes column, and column is flipped
                j++;
            }
            i--; // Move to the previous row
        }

        return resultBox; // Return the rotated box
    }
}
