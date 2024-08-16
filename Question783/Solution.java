public class Solution {
    TreeNode prev = null;
    int result = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return result;
    }

    public void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        if(prev != null) {
            result = Math.min(result, Math.abs(prev.val - root.val));
        }
        prev = root;
        inOrder(root.right);

    }
}
