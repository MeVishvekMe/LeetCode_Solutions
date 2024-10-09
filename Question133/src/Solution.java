import java.util.HashMap;

public class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        // Make a HashMap to connect the original node and new node
        HashMap<Node, Node> map = new HashMap<>();
        // Recursive function starts
        helper(node, map);
        // Returning the new node corresponding to the node
        return map.get(node);
    }

    public void helper(Node node, HashMap<Node, Node> map) {
        // Check if current node is present in HashMap
        // If not, then add the node and create the corresponding node.
        if(!map.containsKey(node)) {
            map.put(node, new Node(node.val));
        }
        // Iterate the current node's list
        for(Node n : node.neighbors) {
            // If n isn't found in map, put in map and start a recursive call on it
            if(!map.containsKey(n)) {
                map.put(n, new Node(n.val));
                helper(n, map);
            }
            // Put the value node of node in the corresponding node's list
            map.get(node).neighbors.add(map.get(n));
        }
    }
}

