import java.util.HashSet;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Sliding Window will be used
        // HashSet to check for duplicates
        HashSet<Character> set = new HashSet<>();

        // left and right pointers
        int left = 0;
        int right = 0;

        // variable to keep the track of the maximum length
        int max = 0;

        while(right < s.length()) {
            char c = s.charAt(right);

            // Add to set if not found and move the right pointer
            if(!set.contains(c)) {
                right++;
                set.add(c);
                max = Math.max(right - left, max);
            }
            // Remove from set if the same value is found, move the left pointer as well
            else {
                set.remove(s.charAt(left));
                left++;
            }

        }

        // return the max variable
        return max;
    }
}
