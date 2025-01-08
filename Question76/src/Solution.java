import java.util.HashMap;

public class Solution {
    public String minWindow(String s, String t) {
        // Create a hashmap to store the frequency of characters in string 't'
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        // Variables to track the state of the sliding window
        int start = 0; // Start index of the minimum window substring
        int left = 0; // Left pointer of the sliding window
        int right = 0; // Right pointer of the sliding window
        int found = 0; // Number of characters in 't' that are matched
        int minimumSubstringLength = Integer.MAX_VALUE; // Length of the smallest valid window

        // Expand the window by moving the right pointer
        while (right < s.length()) {
            char currentRight = s.charAt(right);

            // If the current character is in 't', decrease its count in the map
            if (map.containsKey(currentRight)) {
                if (map.get(currentRight) > 0) {
                    found++; // Increment found if it's a character still needed
                }
                map.put(currentRight, map.get(currentRight) - 1);
            }

            // When all characters in 't' are matched, try to shrink the window
            while (found == t.length()) {
                // Update the minimum window substring if a smaller one is found
                if (right - left + 1 < minimumSubstringLength) {
                    start = left; // Update the start index
                    minimumSubstringLength = right - left + 1;
                }

                char currentLeft = s.charAt(left);

                // If the left character is in 't', update the map and decrease 'found'
                if (map.containsKey(currentLeft)) {
                    if (map.get(currentLeft) == 0) {
                        found--; // Decrease found as the character is no longer completely matched
                    }
                    map.put(currentLeft, map.get(currentLeft) + 1);
                }

                left++; // Shrink the window from the left
            }

            right++; // Expand the window from the right
        }

        // If no valid window was found, return an empty string
        return minimumSubstringLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minimumSubstringLength);
    }
}