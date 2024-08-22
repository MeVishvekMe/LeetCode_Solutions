public class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                markOs(board, 0, j);
            }
            if (board[rows - 1][j] == 'O') {
                markOs(board, rows - 1, j);
            }
        }

        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                markOs(board, i, 0);
            }
            if (board[i][cols - 1] == 'O') {
                markOs(board, i, cols - 1);
            }
        }


        int i = 0;
        while(i < board.length) {
            int j = 0;
            while(j < board[i].length) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if(board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
                j++;
            }
            i++;
        }
        
    }

    
    

    public void markOs(char[][] board, int i, int j) {
        board[i][j] = 'T';
        if(i + 1 < board.length && board[i + 1][j] == 'O') {
            markOs(board, i + 1, j);
        }
        if(j + 1 < board[i].length && board[i][j + 1] == 'O') {
            markOs(board, i, j + 1);
        }
        if(i - 1 > -1 && board[i - 1][j] == 'O') {
            markOs(board, i - 1, j);
        }
        if(j - 1 > -1 && board[i][j - 1] == 'O') {
            markOs(board, i, j - 1);
        }
    }
}
