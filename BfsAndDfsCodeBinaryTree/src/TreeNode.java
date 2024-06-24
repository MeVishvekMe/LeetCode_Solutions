public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(){
        val = 0;
        left = null;
        right = null;
    }

    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
