public class Solution {
    // Main function that initiates the DFS traversal
    public int goodNodes(TreeNode root) {
        // Start DFS with the root node and initialize max to the smallest possible value
        return dfs(root, Integer.MIN_VALUE);
    }

    // Helper function to count "good" nodes recursively
    private int dfs(TreeNode root, int max) {
        // Base case: If the node is null, return 0 (no good nodes)
        if (root == null)
            return 0;

        // Check if the current node is a "good" node
        // A node is "good" if its value is greater than or equal to the max value seen so far
        int res = (root.val >= max) ? 1 : 0;

        // Update max value to ensure we track the highest value in the path
        int newMax = Math.max(max, root.val);

        // Recursively check left and right subtrees, summing up the good nodes
        return res + dfs(root.left, newMax) + dfs(root.right, newMax);
    }
}