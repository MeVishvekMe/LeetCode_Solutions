public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int n = 0;
        ListNode temp = head;
        while(temp != null) {
            temp = temp.next;
            n++;
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
