public class Solution {
    public int search(int[] nums, int target) {
        // Initialize the left and right pointers to define the search range
        int left = 0;
        int right = nums.length - 1;

        // Perform binary search while the search range is valid
        while (left <= right) {
            // Calculate the middle index in a way that avoids overflow
            int mid = left + (right - left) / 2;

            // Check if the target is at the middle index
            if (nums[mid] == target) {
                return mid; // Return the index if the target is found
            }
            // If the target is smaller than the middle element, adjust the right pointer
            else if (nums[mid] > target) {
                right = mid - 1; // Narrow the search range to the left half
            }
            // If the target is larger than the middle element, adjust the left pointer
            else {
                left = mid + 1; // Narrow the search range to the right half
            }
        }

        // If the loop ends without finding the target, return -1
        return -1;
    }
}
