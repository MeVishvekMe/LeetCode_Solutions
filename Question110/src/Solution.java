class Solution {
    public boolean isBalanced(TreeNode root) {
        // Call the helper function checkBalance to determine if the tree is balanced.
        // If checkBalance returns -1, it means the tree is unbalanced.
        return checkBalance(root) != -1;
    }

    private int checkBalance(TreeNode node) {
        // Base case: If the node is null, return 0 (height of an empty tree is 0).
        if (node == null) {
            return 0;
        }

        // Recursively check the balance and height of the left subtree.
        int leftDepth = checkBalance(node.left);
        // If the left subtree is unbalanced, propagate -1 up the recursion stack.
        if (leftDepth == -1) return -1;

        // Recursively check the balance and height of the right subtree.
        int rightDepth = checkBalance(node.right);
        // If the right subtree is unbalanced, propagate -1 up the recursion stack.
        if (rightDepth == -1) return -1;

        // Check if the current node's subtree is unbalanced.
        // If the absolute difference between left and right subtree heights is more than 1,
        // return -1 to indicate that the tree is unbalanced.
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }

        // If balanced, return the height of the current subtree.
        return 1 + Math.max(leftDepth, rightDepth);
    }
}