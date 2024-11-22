import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    // List for adding sub-lists
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Sorting the array
        Arrays.sort(candidates);

        // Maintaining a currentList in which elements will be added and removed
        List<Integer> currentList = new ArrayList<>();

        // First call
        helper(0, candidates, target, currentList);

        return result;
    }


    public void helper(int currentIndex, int[] candidates, int target, List<Integer> currentList) {
        // Check for target
        if(target == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        int i = currentIndex;
        while(i < candidates.length && candidates[i] <= target) {
            // Add current element to the list
            currentList.add(candidates[i]);

            // Keep subtracting target when calling
            helper(i, candidates, target - candidates[i], currentList);

            // Remove the recent element
            currentList.removeLast();
            
            i++;
        }
    }




}
