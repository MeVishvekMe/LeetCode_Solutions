import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {

        // Create a HashSet for keeping a track of numbers which are not yet added to the set
        HashSet<Integer> set = new HashSet<>();

        for(int i : nums) {

            // If a number is found in set means it has appeared minimum twice, hence return true
            if(set.contains(i)) {
                return true;
            }

            // Add the number to set if not found
            set.add(i);
        }
        
        // return false if all the numbers are unique
        return false;
    }
}