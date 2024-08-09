public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        // Flatten the left and right subtrees
        flatten(root.left);
        flatten(root.right);

        // Save the left and right children
        TreeNode left = root.left;
        TreeNode right = root.right;

        // Attach the left subtree to the right
        root.left = null;
        root.right = left;

        // Find the rightmost node of the left subtree
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }

        // Attach the original right subtree
        current.right = right;
    }
}
