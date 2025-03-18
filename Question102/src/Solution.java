import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>(); // Stores the final level order traversal

        // If the tree is empty, return an empty list
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>(); // Queue to store nodes for BFS
        queue.offer(root); // Start with the root node

        while (!queue.isEmpty()) { // Process nodes level by level
            int levelSize = queue.size(); // Number of nodes in the current level
            List<Integer> levelNodes = new ArrayList<>(); // List to store values of nodes in the current level

            // Process all nodes in the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll(); // Get the front node from the queue
                levelNodes.add(current.val); // Add the node's value to the level list

                // Add left and right children to the queue if they exist
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            result.add(levelNodes); // Add the current level's nodes to the result list
        }
        return result; // Return the level order traversal result
    }
}