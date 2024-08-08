import java.util.HashMap;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        while(i < preorder.length) {
            map.put(inorder[i], i);
            i++;
        }
        TreeNode root = helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
        return root;
    }

    public TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd, HashMap<Integer, Integer> map) {
        if(preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int idx = map.get(preorder[preStart]);
        int numsLeft = idx - inStart;
        root.left = helper(preorder, inorder, preStart + 1, preStart + numsLeft, inStart, idx - 1, map);
        root.right = helper(preorder, inorder, preStart + numsLeft + 1, preEnd, idx + 1, inEnd, map);
        return root;
    }
}
