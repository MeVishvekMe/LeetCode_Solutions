import java.util.HashMap;

class Solution {
    public Node copyRandomList(Node head) {
        // Create a HashMap to store the mapping of original nodes to their copies
        HashMap<Node, Node> map = new HashMap<>();

        // First pass: Create a copy of each node and store it in the map
        Node current = head;
        while (current != null) {
            map.put(current, new Node(current.val)); // Create a new node with the same value
            current = current.next; // Move to the next node
        }

        // Second pass: Assign the next and random pointers to the copied nodes
        current = head;
        while (current != null) {
            Node currentCopy = map.get(current); // Get the copied node from the map
            currentCopy.next = map.get(current.next); // Set the next pointer in the copied list
            currentCopy.random = map.get(current.random); // Set the random pointer in the copied list
            current = current.next; // Move to the next node in the original list
        }

        // Return the head of the copied linked list
        return map.get(head);
    }

}
