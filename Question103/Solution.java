
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            System.out.println("Null Node");
            return new ArrayList<>();
        }
        List<List<Integer>> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;
        while(!queue.isEmpty()) {
            int i = 0;
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while(i < size) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
                i++;
            }
            
            if(!leftToRight) {
                Collections.reverse(list);
            }
            resultList.add(list);
            leftToRight = !leftToRight;
        }
        return resultList;
    }
}
