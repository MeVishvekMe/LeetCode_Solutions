import java.util.HashSet;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        long sum = 0, currentSum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            while (set.contains(nums[right])) {
                // Remove leftmost element to resolve duplicates
                set.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }

            // Add current element to the window
            set.add(nums[right]);
            currentSum += nums[right];

            // Check if the window size is exactly k
            if (right - left + 1 == k) {
                sum = Math.max(sum, currentSum);
                // Slide the window
                set.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }
        }

        return sum;
    }
}
