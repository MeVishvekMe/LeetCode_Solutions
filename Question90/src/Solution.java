import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // Sort the array to ensure duplicates are adjacent
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        // Start the backtracking from index 0 with an empty path
        backtrack(0, nums, new ArrayList<>(), result);

        return result;
    }
    
    private void backtrack(int start, int[] nums, List<Integer> path, List<List<Integer>> result) {
        // Add a copy of the current subset (path) to the result
        result.add(new ArrayList<>(path));

        // Iterate through the array starting from 'start'
        for (int i = start; i < nums.length; i++) {
            // Skip duplicates: if the current number is the same as the previous
            // and it's not the first number at this level of recursion
            if (i > start && nums[i] == nums[i - 1]) continue;

            // Include nums[i] in the current subset
            path.add(nums[i]);

            // Move to the next index
            backtrack(i + 1, nums, path, result);

            // Backtrack: remove the last added element
            path.remove(path.size() - 1);
        }
    }
}
