class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to simplify the merging process
        ListNode dummy = new ListNode(-1);
        // Pointer 'temp' will be used to build the merged list
        ListNode temp = dummy;

        // Traverse both lists while neither is exhausted
        while (list1 != null && list2 != null) {
            // Compare current nodes of both lists and attach the smaller one
            if (list1.val <= list2.val) {
                temp.next = list1;  // Attach list1 node to merged list
                list1 = list1.next; // Move list1 pointer forward
            } else {
                temp.next = list2;  // Attach list2 node to merged list
                list2 = list2.next; // Move list2 pointer forward
            }
            temp = temp.next; // Move temp pointer forward in the merged list
        }

        // If one of the lists is not exhausted, attach the remaining part to merged list
        temp.next = (list1 != null) ? list1 : list2;

        // Return the merged list starting from the first real node (skipping dummy node)
        return dummy.next;
    }
}