import java.util.HashSet;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty())
            return 0;
        
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int result = 1;
        while(right < s.length()) {
            if(set.contains(s.charAt(right))) {
                set.remove(s.charAt(left))  ;
                left++;
            }
            else {
                set.add(s.charAt(right));
                right++;
                result = Math.max(result, set.size());
            }
        }
        return result;
    }
}
