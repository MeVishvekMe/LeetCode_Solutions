class Solution {
    public int countNodes(TreeNode root) {

        // Return 0 if current node is null.
        if(root == null) {
            return 0;
        }
        // For calculating the levels we need to check extreme left and extreme right of the current root
        int leftLevel = calculateLeft(root);
        int rightLevel = calculateRight(root);

        // If the levels are same, we can apply the formula 2^n - 1
        if(leftLevel == rightLevel) {
            return ((2 << (leftLevel)) - 1);
        }

        // Recursive call to the left node and right node if levels are not same, add 1 in the end for the current node.
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private int calculateLeft(TreeNode root) {
        int count = 0;
        while(root.left != null) {
            count++;
            root = root.left;
        }
        return count;
    }

    private int calculateRight(TreeNode root) {
        int count = 0;
        while(root.right != null) {
            count++;
            root = root.right;
        }
        return count;
    }
}