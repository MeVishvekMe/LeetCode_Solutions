import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result, 0);
        return result;
    }
    public void helper (TreeNode root, List<Integer> result, int depth) {
        if(root == null) {
            return;
        }
        if(result.size() == depth) {
            result.add(root.val);
        }
        helper(root.right, result, depth + 1);
        helper(root.left, result, depth + 1);
    }
}