public class Main {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(3);
        list1.next = new ListNode(4);

        ListNode list2 = new ListNode(9);
        list2.next = new ListNode(1);

        Solution solution = new Solution();
        ListNode temp = solution.addTwoNumbers(list1, list2);
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
