import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public void bfs(TreeNode root) {
        if(root == null) {
            System.out.println("Null Node");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            System.out.print(temp.val + " ");
            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
        }
    }
}
