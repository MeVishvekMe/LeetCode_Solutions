class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both trees are null, they are the same
        if (p == null && q == null) {
            return true;
        }

        // If one tree is null and the other is not, or if the values of the nodes are different, they are not the same
        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        // Recursively check if the left subtrees and right subtrees are the same
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
