public class Solution {
    public boolean hasCycle(ListNode head) {
        // If the list is empty or has only one node, it can't have a cycle
        if (head == null || head.next == null) {
            return false;
        }

        // Use two pointers: slow moves one step at a time, fast moves two steps
        ListNode slow = head;
        ListNode fast = head;

        // Traverse the linked list
        while (fast != null && fast.next != null) {
            slow = slow.next;        // Move slow pointer by 1 step
            fast = fast.next.next;   // Move fast pointer by 2 steps

            // If slow and fast meet, there is a cycle in the list
            if (slow == fast) {
                return true;
            }
        }

        // If we reach the end of the list, there's no cycle
        return false;
    }
}
