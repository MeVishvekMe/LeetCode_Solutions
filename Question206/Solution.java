class Solution {

    // Iterative Approach
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while(current != null){
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    // Recursive Approach
    public ListNode reverseList1(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode reversedHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reversedHead;
    }
}