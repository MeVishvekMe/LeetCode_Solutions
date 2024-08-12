public class Main {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(2);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);

        System.out.println(new Solution().rightSideView(tree));
    }
}