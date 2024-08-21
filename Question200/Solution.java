public class Solution {
    public int numIslands(char[][] grid) {
        int island = 0;
        int i = 0;
        while(i < grid.length) {
            int j = 0;
            while(j < grid[i].length) {
                if(grid[i][j] == '1') {
                    helper(grid, i, j);
                    island++;
                }
                j++;
            }
            i++;
        }
        
        return island;
    }

    public void helper(char[][] grid, int row, int column) {
        grid[row][column] = '0';
        if((row + 1) < grid.length && grid[row + 1][column] == '1') {
            helper(grid, row + 1, column);
        }
        if((column + 1) < grid[row].length && grid[row][column + 1] == '1') {
            helper(grid, row, column + 1);
        }
        if((column - 1) > -1 && grid[row][column - 1] == '1') {
            helper(grid, row, column - 1);
        }
        if((row - 1) > -1 && grid[row - 1][column] == '1') {
            helper(grid, row - 1, column);
        }
    }


}
