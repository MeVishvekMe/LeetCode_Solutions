import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>(); // List to store all valid combinations
        backtracking(0, candidates, target, new ArrayList<>(), result); // Start backtracking
        return result; // Return the list of valid combinations
    }
    
    private void backtracking(int start, int[] candidates, int target, List<Integer> currentList, List<List<Integer>> result) {
        // Base case: If the target becomes 0, we found a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(currentList)); // Add a copy of the current list to the result
            return;
        }

        // If the target becomes negative, stop recursion (no valid combination)
        if (target < 0) return;

        // Iterate through candidates, starting from 'start' to avoid duplicate subsets
        for (int i = start; i < candidates.length; i++) {
            // Choose the current number
            currentList.add(candidates[i]);

            // Recur with the same index (i) since we can reuse the same element
            backtracking(i, candidates, target - candidates[i], currentList, result);

            // Undo the last choice (backtrack) to explore other possibilities
            currentList.remove(currentList.size() - 1);
        }
    }
}
