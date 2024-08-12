import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> result = helper(queue, new ArrayList<>());
        return result;
    }

    public List<Integer> helper(Queue<TreeNode> queue, List<Integer> result) {
        if(queue.isEmpty()) {
            return result;
        }
        int size = queue.size();
        int i = 0;
        while(i < size) {
            TreeNode current = queue.poll();
            if(current.left != null) {
                queue.add(current.left);
            }
            if(current.right != null) {
                queue.add(current.right);
            }
            if(i == (size - 1)) {
                result.add(current.val);
            }
            i++;
        }
        helper(queue, result);
        return result;
    }
}
