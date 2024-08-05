public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];
        for(char c: s.toCharArray()) {
            arr[c - 97]++;
        }
        for(char c: t.toCharArray()) {
            if(arr[c - 97] == 0) {
                return false;
            }
            else {
                arr[c - 97]--;
            }
        }
        return true;
    }
}
