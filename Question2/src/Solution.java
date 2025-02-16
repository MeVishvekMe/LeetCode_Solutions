class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create a dummy node to simplify handling the result linked list
        ListNode dummy = new ListNode(-1);
        // Pointer to traverse and build the result list
        ListNode current = dummy;
        // Variable to store the carry from each addition
        int carry = 0;

        // Iterate as long as there are nodes in either list or there's a carry
        while (l1 != null || l2 != null || carry != 0) {
            // Get the current values of the nodes, if they exist
            int val1 = (l1 == null) ? 0 : l1.val;
            int val2 = (l2 == null) ? 0 : l2.val;

            // Compute sum and carry
            int sum = val1 + val2 + carry;
            carry = sum / 10; // Extract the carry for the next iteration

            // Create a new node for the sum's unit place and link it to the result list
            current.next = new ListNode(sum % 10);
            current = current.next; // Move the pointer forward

            // Move to the next nodes in the input lists (if available)
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // Return the result list starting from the next node of dummy
        return dummy.next;
    }
}