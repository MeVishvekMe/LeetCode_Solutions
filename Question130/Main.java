public class Main {
    public static void main(String[] args) {
        char[][] board = {
            {'O', 'X', 'X', 'O', 'X'},
            {'X', 'O', 'O', 'X', 'O'},
            {'X', 'O', 'X', 'O', 'X'},
            {'O', 'X', 'O', 'O', 'O'},
            {'X', 'X', 'O', 'X', 'O'}
        };

        char[][] board1 = {
            {'O'}
        };

        new Solution().solve(board);
    }
}