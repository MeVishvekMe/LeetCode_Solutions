import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        // Sort the array to handle duplicates and allow early pruning
        Arrays.sort(candidates);

        // Start backtracking from index 0 with empty path and full target
        backtrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }
    
    private void backtrack(int[] candidates, int remaining, int startIndex, List<Integer> path, List<List<Integer>> result) {
        // Base case: if the remaining target is 0, we found a valid combination
        if (remaining == 0) {
            result.add(new ArrayList<>(path)); // Add a copy of current path
            return;
        }

        // Iterate through the candidates starting from startIndex
        for (int i = startIndex; i < candidates.length; i++) {
            // Skip duplicates: if the current value is the same as the previous one at the same level
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Prune the search if the current number exceeds the remaining sum
            if (candidates[i] > remaining) {
                break; // Since the array is sorted, no need to check further
            }

            // Choose the current number
            path.add(candidates[i]);

            // Recurse with updated remaining target and next index (i + 1 because each number can be used once)
            backtrack(candidates, remaining - candidates[i], i + 1, path, result);

            // Backtrack: remove the last added number to try another candidate
            path.remove(path.size() - 1);
        }
    }
}
