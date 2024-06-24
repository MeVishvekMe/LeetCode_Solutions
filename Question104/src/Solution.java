public class Solution {
    int depthVar = 1;
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        depth(root, 1);
        return depthVar;
    }
    public void depth(TreeNode root, int depth) {
        if(root.left == null && root.right == null) {
            if(depth > depthVar) {
                depthVar = depth;
            }
            return;
        }
        if(root.left != null)
            depth(root.left, depth + 1);
        if(root.right != null)
            depth(root.right, depth + 1);
    }
}
