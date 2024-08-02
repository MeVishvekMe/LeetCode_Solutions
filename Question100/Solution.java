public class Solution {

    boolean result = true;

    public boolean isSameTree(TreeNode p, TreeNode q) {
        checkTrees(p, q);
        return result;
    }
    
    public void checkTrees(TreeNode p, TreeNode q) {
        if(!result || (p == null && q == null))
            return;
        if(
            (p == null && q != null) ||
            (q == null && p != null) ||
            (p.val != q.val)
        ) {
            result = false;
            return;
        }
        checkTrees(p.left, q.left);
        checkTrees(p.right, q.right);
    }

}