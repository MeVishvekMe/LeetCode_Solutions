import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // List to store the resulting triplets
        List<List<Integer>> result = new ArrayList<>();

        // Step 1: Sort the array to simplify the two-pointer logic
        Arrays.sort(nums);

        // Step 2: Iterate through the array, considering each element as a potential first number of the triplet
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Define the target value for the two-sum problem
            int target = -nums[i];
            int left = i + 1;          // Left pointer starts just after the current element
            int right = nums.length - 1; // Right pointer starts at the end of the array

            // Step 3: Use the two-pointer technique to find pairs that sum up to the target
            while (left < right) {
                int sum = nums[left] + nums[right]; // Calculate the sum of the two pointers

                if (sum == target) {
                    // If the sum matches the target, we found a valid triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Move the pointers to avoid duplicates and find other pairs
                    left++;
                    right--;

                    // Skip duplicate elements for the left pointer
                    while (left < right && nums[left] == nums[left - 1]) left++;

                    // Skip duplicate elements for the right pointer
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < target) {
                    // If the sum is less than the target, move the left pointer to increase the sum
                    left++;
                } else {
                    // If the sum is greater than the target, move the right pointer to decrease the sum
                    right--;
                }
            }
        }
        // Return the list of unique triplets
        return result;
    }
}