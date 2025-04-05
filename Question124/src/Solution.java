class Solution {
    // Initialize maxSum to the smallest possible value to handle trees with all negative values
    private int maxSum = Integer.MIN_VALUE;

    // Main function to start the DFS and return the maximum path sum
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    // Helper function to perform post-order traversal and compute max gains
    private int dfs(TreeNode node) {
        if (node == null) return 0; // Base case: null nodes contribute 0 to the path

        // Recursively calculate the maximum path sum for left and right children
        // If the result is negative, we discard it by taking 0 instead
        int left = Math.max(dfs(node.left), 0);
        int right = Math.max(dfs(node.right), 0);

        // Calculate the maximum path sum passing through the current node (including both children)
        int currentPathSum = node.val + left + right;

        // Update global maximum if the current path sum is greater
        maxSum = Math.max(maxSum, currentPathSum);

        // Return the maximum gain from the current node if continuing the path upwards
        return node.val + Math.max(left, right);
    }
}