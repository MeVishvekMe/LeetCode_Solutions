import java.util.PriorityQueue;

class Solution {
    public int minOperations(int[] nums, int k) {
        // Min heap (priority queue) to store elements less than k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add only numbers less than k into the min heap
        for (int i : nums) {
            if (i < k) {
                minHeap.add(i);
            }
        }

        int operations = 0; // Count of operations performed

        // Process elements in the min heap
        while (!minHeap.isEmpty()) {
            // Extract the smallest element
            int x = minHeap.poll();
            operations++; // Increment operation count

            // If the heap is empty after polling the first element, exit the loop
            if (minHeap.isEmpty()) {
                break;
            }

            // Extract the second smallest element
            int y = minHeap.poll();

            // Combine the two numbers using the given formula:
            // new_num = (min(x, y) * 2) + max(x, y)
            long num = (Math.min(x, y) * 2L) + Math.max(x, y);

            // If the new number is still less than k, add it back to the heap
            if (num < k) {
                minHeap.add((int) num); // Convert long to int before adding
            }
        }

        return operations; // Return the number of operations performed
    }
}
