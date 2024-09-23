import java.util.HashMap;

public class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head.next;
        Node newHead = new Node(head.val);
        Node newTemp = newHead;
        map.put(head, newHead);
        while(temp != null) {
            newTemp.next = new Node(temp.val);
            map.put(temp, newTemp.next);
            temp = temp.next;
            newTemp = newTemp.next;
        }
        temp = head;
        newTemp = newHead;
        while(temp != null) {
            newTemp.random = map.get(temp.random);
            temp = temp.next;
            newTemp = newTemp.next;
        }
        return newHead;
    }

}
