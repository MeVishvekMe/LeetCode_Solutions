import java.util.HashMap;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Create a HashMap to store the index of each value in the inorder array
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // Call the recursive helper function to construct the binary tree
        return helper(0, 0, inorder.length - 1, preorder, inorderMap);
    }

    private TreeNode helper(int current, int inStart, int inEnd, int[] preorder, HashMap<Integer, Integer> map) {
        // Base case: if the index is out of range, return null (no node)
        if (current > preorder.length - 1 || inStart > inEnd) return null;

        // Get the value of the current root node from the preorder array
        int rootVal = preorder[current];

        // Find the index of this value in the inorder array
        int index = map.get(rootVal);

        // Create the root node with the extracted value
        TreeNode root = new TreeNode(rootVal);

        // Recursively build the left subtree
        // - The next element in preorder is the left child
        // - The left subtree consists of elements in inorder from inStart to index - 1
        root.left = helper(current + 1, inStart, index - 1, preorder, map);

        // Recursively build the right subtree
        // - Skip over the left subtree elements in preorder
        // - The right subtree consists of elements in inorder from index + 1 to inEnd
        root.right = helper(current + (index - inStart) + 1, index + 1, inEnd, preorder, map);

        // Return the constructed subtree
        return root;
    }
}
