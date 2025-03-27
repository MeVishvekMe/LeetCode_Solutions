public class Solution {
    private int count = 0;  // Counter to track the number of elements visited
    private int result = 0; // Stores the k-th smallest element

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k); // Perform in-order traversal
        return result;    // Return the k-th smallest element
    }

    private void inOrder(TreeNode node, int k) {
        if (node == null) return; // Base case: If the node is null, return

        // Traverse the left subtree (smaller elements)
        inOrder(node.left, k);

        // Increment the counter when visiting a node
        count++;
        if (count == k) {  // If the current node is the k-th smallest
            result = node.val; // Store the value of the k-th smallest element
            return;  // Stop further recursion once the k-th element is found
        }

        // Traverse the right subtree (larger elements)
        inOrder(node.right, k);
    }
}
