import java.util.HashSet;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Set to store and check the entries for duplicate
        HashSet<String> set = new HashSet<>();

        // Iterate the 2D array
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {

                // Stop when a number is found
                if(board[i][j] != '.') {

                    // Generate Strings for row, column and box
                    String row = board[i][j] + "=R" + i;
                    String column = board[i][j] + "=C" + j;
                    String box = board[i][j] + "=B" + (i / 3) + "," + (j / 3);

                    // If same Strings found in HashSet then return false
                    if(set.contains(row) || set.contains(column) || set.contains(box)) {
                        return false;
                    }
                    else {
                        // Add the Strings to the set
                        set.add(row);
                        set.add(column);
                        set.add(box);
                    }
                }
            }
        }

        // return true if iteration of whole array is completed
        return true;
    }
}
