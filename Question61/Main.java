public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode temp = new Solution().rotateRight(head, 2);
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}