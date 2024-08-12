import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null) {
            System.out.println("Null Node");
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> result = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int i = 0;
            int size = queue.size();
            double total = 0.0;
            while(i < size) {
                TreeNode temp = queue.poll();
                total += temp.val;
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
                i++;
            }
            result.add(total / size);
        }
        return result;
    }   
}
