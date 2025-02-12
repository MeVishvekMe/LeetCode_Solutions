class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Initialize pointers to traverse the linked list
        ListNode slow = head;  // Will eventually point to the node to be removed
        ListNode fast = head;  // Will be used to find the nth node from the end
        ListNode prev = null;  // Will track the node before the one to be deleted

        int i = 0;  // Counter to track the fast pointer's movement

        // Move the fast pointer n steps ahead while keeping track of the slow pointer
        while (fast != null) {
            if (i++ >= n) {  // Once fast moves 'n' steps ahead, start moving slow
                prev = slow;  // Track the previous node
                slow = slow.next;  // Move slow one step forward
            }
            fast = fast.next;  // Move fast one step forward
        }

        // If prev is still null, it means we need to remove the head node
        if (prev == null) {
            return slow.next;  // Skip the first node and return the new head
        }

        // Remove the nth node from the end by updating the next pointer
        prev.next = slow.next;
        slow.next = null;  // Isolate the removed node (optional but good practice)

        return head;  // Return the updated linked list
    }
}
