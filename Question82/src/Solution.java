public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head; // Return directly if 0 or 1 node exists
        }

        ListNode dummy = new ListNode(-1); // Dummy node before head
        dummy.next = head;

        ListNode prev = dummy; // Tracks the last unique node
        ListNode current = head; // Pointer for traversing the list

        while (current != null) {
            if (current.next != null && current.val == current.next.val) {
                // Skip all duplicates
                while (current.next != null && current.val == current.next.val) {
                    current = current.next;
                }
                // Connect prev to the node after duplicates
                prev.next = current.next;
            } else {
                // Move prev forward only if current is unique
                prev = current;
            }
            current = current.next; // Move current forward
        }

        return dummy.next;
    }
}
