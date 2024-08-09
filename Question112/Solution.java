public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, targetSum, 0);
    }

    public boolean helper(TreeNode root, int targetSum, int sum) {
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null && sum + root.val == targetSum) {
            return true;
        }
        return helper(root.left, targetSum, sum + root.val) || helper(root.right, targetSum, sum + root.val);
    }
}
