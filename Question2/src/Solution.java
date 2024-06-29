class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = null;
        ListNode temp2 = null;
        ListNode sumTemp = null;
        ListNode sumList = new ListNode(-1);
        sumTemp = sumList;
        temp1 = l1;
        temp2 = l2;
        int carry = 0;
        while (temp1 != null && temp2 != null) {
            int result = temp1.val + temp2.val + carry;
            sumTemp.next = new ListNode(result % 10);
            sumTemp = sumTemp.next;
            carry = result / 10;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        while (temp1 != null) {
            int result = temp1.val + carry;
            sumTemp.next = new ListNode(result % 10);
            sumTemp = sumTemp.next;
            carry = result / 10;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            int result = temp2.val + carry;
            sumTemp.next = new ListNode(result % 10);
            sumTemp = sumTemp.next;
            carry = result / 10;
            temp2 = temp2.next;
        }
        if (carry != 0) {
            sumTemp.next = new ListNode(carry);

        }
        sumList  = sumList.next;
        return sumList;
    }
}