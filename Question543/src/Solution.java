class Solution {
    // Variable to store the maximum diameter found
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        computeHeight(root); // Recursively compute the height of each node
        return maxDiameter; // Return the maximum diameter found
    }

    private int computeHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Recursively compute the height of the left and right subtrees
        int leftHeight = computeHeight(node.left);
        int rightHeight = computeHeight(node.right);

        // Update the max diameter if the sum of left and right heights is larger
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // Return the height of the current node's subtree (1 + max of left and right heights)
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
