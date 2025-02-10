class Solution {
    public int search(int[] nums, int target) {
        // Initialize two pointers: left (start of array) and right (end of array)
        int left = 0;
        int right = nums.length - 1;

        // Perform binary search
        while (left <= right) {
            // Find the middle index to divide the search space
            int mid = left + (right - left) / 2;

            // If the middle element is the target, return its index
            if (nums[mid] == target) {
                return mid;
            }

            // Check if the left half is sorted
            if (nums[mid] >= nums[left]) {
                // Check if the target is within the sorted left half
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid - 1; // Search in the left half
                } else {
                    left = mid + 1;  // Search in the right half
                }
            }
            // Otherwise, the right half must be sorted
            else {
                // Check if the target is within the sorted right half
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid + 1; // Search in the right half
                } else {
                    right = mid - 1; // Search in the left half
                }
            }
        }
        // If the target is not found, return -1
        return -1;
    }
}
