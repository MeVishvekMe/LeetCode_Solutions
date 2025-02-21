class Solution {
    public int findDuplicate(int[] nums) {
        // Initialize two pointers: slow and fast
        int slow = 0, fast = 0;

        // Phase 1: Detect cycle using Floyd's Tortoise and Hare algorithm
        while (true) {
            slow = nums[slow];        // Move slow pointer by one step
            fast = nums[nums[fast]];  // Move fast pointer by two steps

            // If slow and fast meet, a cycle is detected
            if (slow == fast) {
                break;
            }
        }

        // Phase 2: Find the entrance of the cycle (which is the duplicate number)
        int slow2 = 0;  // Start another pointer from the beginning
        while (true) {
            slow = nums[slow];   // Move both slow and slow2 by one step
            slow2 = nums[slow2];

            // When they meet, we found the duplicate number
            if (slow == slow2) {
                return slow;
            }
        }
    }
}
