class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root; // Start from the root of the tree

        // Iterate while the current node is not null
        while (current != null) {
            // If both p and q are greater than current, LCA must be in the right subtree
            if (p.val > current.val && q.val > current.val) {
                current = current.right;
            }
            // If both p and q are smaller than current, LCA must be in the left subtree
            else if (p.val < current.val && q.val < current.val) {
                current = current.left;
            }
            // If p and q are on different sides or one of them is the current node, we found the LCA
            else {
                return current;
            }
        }

        return null; // In case p or q is not found, return null (should not happen in a valid BST scenario)
    }
}
