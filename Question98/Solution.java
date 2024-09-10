public class Solution {
    boolean result = true;

    public boolean isValidBST(TreeNode root) {
        helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return result;
    }

    public void helper(TreeNode root, long low, long high) {
        if(root == null || !result) {
            return;
        }
        if(root.val < high && root.val > low) {
            helper(root.left, low, root.val);
            helper(root.right, root.val, high);
        }
        else {
            result = false;
            return;
        }
    }
}
