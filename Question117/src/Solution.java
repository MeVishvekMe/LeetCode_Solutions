import java.util.LinkedList;
import java.util.Queue;

class Solution {

    // ------------ This solution is Time : O(n) and Space O(1) --------------
    public Node connect(Node root) {
        if(root == null) {
            return null;
        }
        // Save the original root in some reference since we're going to modify the root.
        Node originalRoot = root;

        // Create a dummy node
        Node dummy = new Node(0);

        // Initialize temp with dummy
        Node temp = dummy;
        while(root != null) {
            // Connect dummy with left if it's the first element in current level
            if(root.left != null) {
                temp.next = root.left;
                temp = temp.next;
            }

            // Connect dummy with right if it's the first element in current level
            // If dummy is connect to left then temp is on left
            // Connect temp to right if != null
            if(root.right != null) {
                temp.next = root.right;
                temp = temp.next;
            }

            // Move root to the next
            root = root.next;

            // If root is found null, make it equal to next of dummy
            if(root == null) {
                temp = dummy;
                root = dummy.next;
                dummy.next = null;
            }
        }

        // Return the original node
        return originalRoot;
    }



    // -------------- This solution is Time : O(n) and Space : O(n) ------------
    // Normal BFS Approach
//    public Node connect(Node root) {
//        if(root == null)
//            return null;
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(root);
//        while(!queue.isEmpty()) {
//            int n = queue.size();
//            int i = 0;
//            while(i < n) {
//                Node current = queue.poll();
//                if(i == n - 1) {
//                    current.next = null;
//                }
//                else {
//                    current.next = queue.peek();
//                }
//                i++;
//                if(current.left != null) {
//                    queue.add(current.left);
//                }
//                if(current.right != null) {
//                    queue.add(current.right);
//                }
//            }
//        }
//        return root;
//    }
}