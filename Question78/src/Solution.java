import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // List to store all subsets
        List<List<Integer>> result = new ArrayList<>();

        // Start backtracking from index 0 with an empty subset
        backtrack(0, nums, new ArrayList<>(), result);

        return result; // Return the final list of subsets
    }

    private void backtrack(int start, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Add the current subset to the result (create a copy to avoid modification issues)
        result.add(new ArrayList<>(current));

        // Iterate over the remaining elements
        for (int i = start; i < nums.length; i++) {
            // Include nums[i] in the current subset
            current.add(nums[i]);

            // Recur with the next element (i + 1) to build further subsets
            backtrack(i + 1, nums, current, result);

            // Remove the last added element to backtrack and explore other possibilities
            current.remove(current.size() - 1);
        }
    }
}
