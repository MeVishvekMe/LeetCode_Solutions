import java.util.HashMap;

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for(int k : inorder) {
            map.put(k, i);
            i++;
        }
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, map);
    }

    public TreeNode helper(int[] inorder, int[] postorder, int inLow, int inHigh, int postLow, int postHigh, HashMap<Integer, Integer> map) {
        if(inLow > inHigh || postLow > postHigh) {
            return null;
        }
        TreeNode head = new TreeNode(postorder[postHigh]);
        int inIndex = map.get(postorder[postHigh]);
        int remaining = inHigh - inIndex;
        head.right = helper(inorder, postorder, inIndex + 1, inHigh, postHigh - remaining, postHigh - 1, map);
        head.left = helper(inorder, postorder, inLow, inIndex - 1, postLow, postHigh - remaining - 1, map);
        return head;
    }
}