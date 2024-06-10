public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode single = head;
        ListNode dou = head;
        while (true) {
            dou = dou.next;
            if(compareTwo(dou, single)) {
                return true;
            }
            else if (dou.next == null) {
                return false;
            }
            dou = dou.next;
            if(compareTwo(dou, single)) {
                return true;
            }
            else if (dou.next == null) {
                return false;
            }
            single = single.next;
        }
    }

    private boolean compareTwo(ListNode node1, ListNode node2) {
        return node1 == node2;
    }
}
