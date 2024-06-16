public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);


        ListNode list = solution.mergeTwoLists(list1, list2);
        while(list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
    }
}