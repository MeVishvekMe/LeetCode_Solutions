public class Solution {
    int num = 0;
    int result = -1;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return result;
    }
    public void inOrder(TreeNode root, int k) {
        if(result != -1 || root == null) {
            return;
        }
        inOrder(root.left, k);
        num++;
        if(num == k) {
            result = root.val;
        }
        inOrder(root.right, k);
    }
}
