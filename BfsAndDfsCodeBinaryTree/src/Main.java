public class Main {
    public static void main(String[] args) {
        // Tree 1
        TreeNode root1 = new TreeNode(11);
        root1.left = new TreeNode(15);
        root1.right = new TreeNode(16);
        root1.left.left = new TreeNode(8);
        root1.left.right = new TreeNode(7);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(6);

        // Tree 2
        TreeNode root2 = new TreeNode(20);
        root2.left = new TreeNode(50);
        root2.right = new TreeNode(1);
        root2.right.left = new TreeNode(7);
        root2.right.right = new TreeNode(8);
        root2.right.left.left = new TreeNode(9);

        // Testing BFS methods
        BFS bfs = new BFS();
        bfs.bfsWithoutDepth(root1);
        System.out.println();
        bfs.bfsWithoutDepth(root2);
        System.out.println();
        bfs.bfsWithDepth(root1);
        bfs.bfsWithDepth(root2);
    }
}
