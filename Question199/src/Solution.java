import java.util.*;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        // List to store the right-side view of the tree
        List<Integer> result = new ArrayList<>();

        // If the tree is empty, return an empty list
        if (root == null) return result;

        // Queue for level-order traversal (BFS)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // Start with the root node

        // Perform BFS traversal level by level
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at the current level
            TreeNode rightmostNode = null; // Variable to keep track of the rightmost node

            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll(); // Get the front node in the queue
                rightmostNode = current; // Update the rightmost node at this level

                // Add left child to the queue if it exists
                if (current.left != null) queue.offer(current.left);
                // Add right child to the queue if it exists
                if (current.right != null) queue.offer(current.right);
            }

            // Add the last node of the level (rightmost node) to the result list
            result.add(rightmostNode.val);
        }

        return result; // Return the list containing the right-side view
    }
}
