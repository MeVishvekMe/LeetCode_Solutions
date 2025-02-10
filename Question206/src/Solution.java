class Solution {
    public ListNode reverseList(ListNode head) {
        // If the list is empty or has only one node, return it as is.
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize two pointers:
        // 'left' will hold the reversed list, initially set to null.
        // 'right' is the current node being processed, starting at head.
        ListNode left = null;
        ListNode right = head;

        // Iterate through the list, reversing the links one by one.
        while (right != null) {
            // Temporarily store the next node to avoid losing track.
            ListNode temp = right.next;

            // Reverse the pointer of the current node.
            right.next = left;

            // Move 'left' one step forward (to the current node).
            left = right;

            // Move 'right' to the next node in the original list.
            right = temp;
        }

        // 'left' now points to the new head of the reversed list.
        return left;
    }
}
