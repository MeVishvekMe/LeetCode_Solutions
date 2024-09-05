public class Solution {
    int result = 0;
    public int totalNQueens(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 0;
        }
        int[][] arr = new int[n][n];
        helper(arr, 0, n);
        return result;
    }

    public void helper(int[][] arr, int row, int n) {
        if(row == n) {
            result++;
            return;
        }
        int column = 0;
        while(column < n) {
            if(isValid(arr, row, column, n)) {
                arr[row][column] = 1;
                helper(arr, row + 1, n);
                arr[row][column] = 0;
            }
            column++;
        }
    }

    public boolean isValid(int[][] arr, int row, int column, int n) {
        int i = row;
        int j = column;
        
        while(i > -1) {
            if(arr[i][j] == 1) {
                return false;
            }
            i--;
        }
        i = row;
        while(i > -1 && j < n) {
            if(arr[i][j] == 1) {
                return false;
            }
            i--;
            j++;
        }
        i = row;
        j = column;

        while(i > -1 && j > -1) {
            if(arr[i][j] == 1) {
                return false;
            }
            i--;
            j--;
        }

        return true;
    }
}
