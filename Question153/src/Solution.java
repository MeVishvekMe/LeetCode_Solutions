public class Solution {
    public int findMin(int[] nums) {
        int left = 0;  // Initialize left pointer at the start of the array
        int right = nums.length - 1;  // Initialize right pointer at the end of the array

        while (left <= right) {
            int mid = left + (right - left) / 2;  // Calculate the middle index to prevent overflow

            // If the array is already sorted (or only one segment left), return the leftmost element
            if (nums[left] <= nums[right]) {
                return nums[left];
            }
            // If the left portion is sorted, move to the right half
            else if (nums[left] <= nums[mid]) {
                left = mid + 1;
            }
            // If the right portion is unsorted, move to the left half
            else {
                right = mid;
            }
        }
        return -1;  // This case should not occur if input is a rotated sorted array
    }
}
