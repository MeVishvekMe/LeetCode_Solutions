public class Solution {
    // Main function to check if a given binary tree is a valid Binary Search Tree (BST)
    public boolean isValidBST(TreeNode root) {
        // Call helper function with initial min and max limits
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // Helper function to check the validity of the BST using recursion
    public boolean checkBST(TreeNode root, long leftLim, long rightLim) {
        // Base case: If the current node is null, it's a valid BST
        if (root == null)
            return true;

        // The current node's value must be strictly within the given range (leftLim, rightLim)
        if (!(root.val > leftLim && root.val < rightLim)) {
            return false;
        }

        // Recursively check the left subtree, updating the right boundary to current node's value
        // Recursively check the right subtree, updating the left boundary to current node's value
        return checkBST(root.left, leftLim, root.val) && checkBST(root.right, root.val, rightLim);
    }
}
