import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Min-heap (PriorityQueue) to store nodes, sorted by their values
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.val, b.val) // Comparator for sorting by node values
        );

        // Add the first node of each list to the min-heap (if it's not null)
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }

        // Dummy node to simplify list construction
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy; // Pointer to track the merged list

        // Process nodes until the heap is empty
        while (!minHeap.isEmpty()) {
            ListNode currentMin = minHeap.poll(); // Get the node with the smallest value
            temp.next = currentMin; // Append it to the merged list

            // If the extracted node has a next node, add it to the heap
            if (currentMin.next != null) {
                minHeap.add(currentMin.next);
            }

            temp = temp.next; // Move to the next position in the merged list
        }

        return dummy.next; // Return the merged list (skip the dummy node)
    }
}
