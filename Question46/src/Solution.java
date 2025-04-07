import java.util.ArrayList;
import java.util.List;

public class Solution {

    // Main function to generate all permutations of the input array
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); // List to store all permutations
        backtracking(0, result, nums); // Start backtracking from index 0
        return result;
    }

    // Recursive backtracking function to generate permutations
    private void backtracking(int index, List<List<Integer>> result, int[] nums) {
        // Base case: if index reaches the end of array, we have a complete permutation
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i : nums)
                list.add(i); // Convert the array to a list and add to result
            result.add(list);
            return;
        }

        // Iterate through all possible numbers for the current index
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i); // Place i-th element at the current index
            backtracking(index + 1, result, nums); // Recurse for the next index
            swap(nums, index, i); // Backtrack: undo the swap to try the next possibility
        }
    }

    // Helper function to swap elements in the array
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
