class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // If k is 1, there is no need to reverse, return the original list
        if(k == 1) {
            return head;
        }

        // Create a dummy node to simplify edge cases (like reversing the first k nodes)
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // Initialize pointers
        ListNode prev = dummy;  // Pointer to the node before the current group
        ListNode start = prev.next;  // Pointer to the first node in the current group
        ListNode end = start;  // Pointer to the last node in the current group
        int i = 1;

        // Traverse the list
        while(end != null) {
            // If we have reached the kth node, it's time to reverse this group
            if(i == k) {
                ListNode next = end.next;  // Store the node after the kth node
                ListNode left = null;  // Pointer used for reversing
                ListNode right = start;  // Pointer to traverse the group

                // Reverse the k nodes
                while(left != end) {
                    ListNode temp = right.next;  // Store the next node
                    right.next = left;  // Reverse the link
                    left = right;  // Move left forward
                    right = temp;  // Move right forward
                }

                // Connect the reversed group with the previous part of the list
                prev.next = end;  // The end node becomes the new start of the reversed group
                start.next = next;  // Connect the original start to the next part of the list

                // Move prev and start pointers for the next group
                prev = start;
                start = next;
                end = start;
                i = 1;  // Reset the counter for the next group
            }
            else {
                i++;  // Increment counter
                end = end.next;  // Move end forward
            }
        }

        // Return the new head of the list
        return dummy.next;
    }
}
