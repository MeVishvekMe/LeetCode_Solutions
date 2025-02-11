class Solution {
    public void reorderList(ListNode head) {
        // Base case: If the list is empty or has only one node, no reordering is needed.
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle of the linked list using slow and fast pointers.
        // Slow pointer moves one step at a time, while fast pointer moves two steps.
        // When fast reaches the end, slow will be at the middle.
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list.
        // The second half starts from the next node after the middle (slow.next).
        ListNode secondHalf = reverseList(slow.next);
        slow.next = null;  // Disconnect the first half from the second half.

        // Step 3: Merge the first and second halves alternately.
        ListNode first = head, second = secondHalf;
        while (second != null) {
            // Store the next nodes to keep track of the remaining list
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            // Insert one node from the second half between the nodes of the first half
            first.next = second;
            second.next = temp1;

            // Move pointers forward
            first = temp1;
            second = temp2;
        }
    }

    // Helper method to reverse a linked list
    private ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;

        // Iterate through the list and reverse the pointer directions
        while (curr != null) {
            ListNode nextTemp = curr.next; // Store the next node
            curr.next = prev;  // Reverse the link
            prev = curr;  // Move prev forward
            curr = nextTemp;  // Move curr forward
        }

        // Return the new head of the reversed list
        return prev;
    }
}
