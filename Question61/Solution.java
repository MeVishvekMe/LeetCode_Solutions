public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        int n = 0;
        ListNode temp = head;
        while(temp != null) {
            temp = temp.next;
            n++;
        }
        k = k % n;
        if(k == 0) {
            return head;
        }
        int i = 1;
        ListNode p = head;
        temp = head;
        while(i < (n - k)) {
            temp = temp.next;
            i++;
        }
        ListNode q = temp.next;
        ListNode r = temp;
        while(r.next != null) {
            r = r.next;
        }
        temp.next = null;
        r.next = p;
        return q;
    }
}
