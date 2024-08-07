public class Solution {
    boolean result = true;
    public boolean isSymmetric(TreeNode root) {
        return checkSym(root.left, root.right);
    }

    public boolean checkSym(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) {
            return true;
        }
        if(node1 == null || node2 == null) {
            return false;
        }
        if(node1.val != node2.val) {
            return false;
        }
        return checkSym(node1.left, node2.right) && checkSym(node1.right, node2.left);
    }
}
