import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public void bfsWithoutDepth(TreeNode root) {
        if(root == null) {
            System.out.println("Null Node");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.val + " ");
            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
        }
    }

    public void bfsWithDepth(TreeNode root) {
        if(root == null) {
            System.out.println("Null Node");
            return;
        }
        List<List<Integer>> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
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
            resultList.add(list);
            depth++;
        }
        System.out.println(resultList);
        System.out.println("Levels : " + depth);
    }
}
