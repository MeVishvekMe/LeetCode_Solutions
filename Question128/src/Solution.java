import java.util.HashSet;

public class Solution {
    public int longestConsecutive(int[] nums) {

        // Populate the set with the elements of nums
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
        }

        // Maintain a variable for the highest count
        int result = 0;

        for(int num : set) {

            // Start from the number from which the sequence will start
            if(!set.contains(num - 1)) {
                int currentNum = num;
                int currentCount = 1;

                // Keep checking the next number and increase the count
                while(set.contains(currentNum + 1)) {
                    currentNum++;
                    currentCount++;
                }

                // Compare with the current highest and update
                result = Math.max(currentCount, result);
            }
        }

        // return result
        return result;
    }
}
