public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;  // Target found
            } else if (nums[mid] < target) {
                left = mid + 1;  // Target might be on the right side
            } else {
                right = mid - 1;  // Target might be on the left side
            }
        }

        // If the target is not found, left will be the correct insertion position
        // In the end(when left == right), if the target is greater than the current mid, left pointer will shift + 1
        // if target is less than the current mind, left pointer will stay as it is and right pointer will shift
        // telling us that left pointer will be the correct position for the target
        return left;
    }
}
