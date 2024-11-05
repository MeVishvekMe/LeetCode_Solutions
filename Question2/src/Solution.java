class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create a separate LinkedList for sum of l1 and l2
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        // Carry variable keep updating in every iteration
        int carry = 0;

        while(l1 != null || l2 != null) {
            // Make a sum and update it
            int sum = 0;

            // Keep adding the value of the current node if != null
            // Update the pointers to the next digit as well
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Add carry now
            sum += carry;

            // Update the digit to add to the summed LinkedList
            int digit = sum % 10;

            // Update carry
            carry = sum / 10;

            // Create a new Node and update it to the dummy node
            temp.next = new ListNode(digit);
            temp = temp.next;
        }

        // Check for carry
        if(carry != 0) {
            temp.next  = new ListNode(carry);
        }

        // Return dummy.next
        return dummy.next;
    }
}