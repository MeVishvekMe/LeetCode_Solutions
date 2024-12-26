import java.util.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // HashMap for storing frequencies and mapping elements to indices
        HashMap<Integer, Integer> map = new HashMap<>();
        int[][] numsFrequencies = new int[nums.length][2];
        int currentIndex = 0;

        // Count frequencies and map each unique number to an index
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, currentIndex);
                numsFrequencies[currentIndex][0] = num; // Store the number
                numsFrequencies[currentIndex][1] = 0;  // Initialize frequency
                currentIndex++;
            }
            numsFrequencies[map.get(num)][1]++; // Increment frequency
        }

        // Sort the array by frequency in descending order
        Arrays.sort(numsFrequencies, 0, currentIndex, (o1, o2) -> Integer.compare(o2[1], o1[1]));

        // Collect the top k elements
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = numsFrequencies[i][0];
        }

        return result;
    }
}
