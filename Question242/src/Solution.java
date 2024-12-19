public class Solution {
    public boolean isAnagram(String s, String t) {

        // If length of s and t are unequal they cannot be anagram
        if(s.length() != t.length()) {
            return false;
        }

        // Instead of using a HashMap to keep the track of the traversed alphabets in s
        // We'll create an array which will keep the track of count of each alphabet in s
        int[] track = new int[26];

        for(int i = 0; i < s.length(); i++) {
            track[s.charAt(i) - 'a']++;
        }

        // Iterate the t string and find for any 0 values in the array for the corresponding index
        for(int i = 0; i < t.length(); i++) {
            char currentChar = t.charAt(i);

            // If value found 0, return false
            if(track[currentChar - 'a'] == 0) {
                return false;
            }
            track[currentChar - 'a']--;
        }

        // return true if outside the loop
        return true;
    }
}
