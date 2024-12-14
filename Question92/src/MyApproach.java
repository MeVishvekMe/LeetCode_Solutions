public class MyApproach {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // If the list is empty or there is no need to reverse (left == right), return the original list
        if (head == null || left == right) {
            return head;
        }

        // Create a dummy node to handle edge cases (e.g., reversing the head of the list)
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // Step 1: Move `prev` to the node just before the start of the reversal range
        int i = 0; // Index tracker
        ListNode prev = dummy; // Start `prev` at the dummy node
        while (i < left - 1) {
            prev = prev.next; // Move `prev` forward to the node before the reversal range
            i++;
        }

        // Save the position of `prev` (just before the reversal range)
        ListNode pre = prev;

        // Step 2: Set up pointers for the reversal
        ListNode current = prev.next; // `current` points to the first node in the reversal range
        ListNode nex = current.next;  // `nex` is the next node to be processed

        // Increment index to the first node in the reversal range
        i++;

        // Step 3: Reverse the nodes in the specified range
        while (i <= right) {
            // Reverse the link: point `current.next` to `pre`
            current.next = pre;
            // Move the `pre` pointer forward to `current`
            pre = current;
            // Move the `current` pointer forward to `nex`
            current = nex;
            // Advance `nex` to the next node, if it exists
            if (nex != null) {
                nex = nex.next;
            }
            i++; // Increment the index
        }

        // Step 4: Reconnect the reversed sublist with the rest of the list
        prev.next.next = current; // Connect the last node in the reversed sublist to the node after the reversal range
        prev.next = pre;          // Connect `prev.next` to the new head of the reversed sublist

        // Step 5: Return the modified list
        return dummy.next;
    }
}
