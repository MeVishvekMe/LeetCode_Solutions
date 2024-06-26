public class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.isEmpty())
            return true;
        if(t.isEmpty())
            return false;
        int i = 0;
        int j = 0;
        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        if(i == s.length())
            return true;
        return false;
    }
}
