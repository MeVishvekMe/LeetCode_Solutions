import java.util.HashMap;
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        while(i < magazine.length()) {
            if(!map.containsKey(magazine.charAt(i))) {
                map.put(magazine.charAt(i), 1);
            }
            else {
                map.put(magazine.charAt(i), map.get(magazine.charAt(i)) + 1);
            }
            i++;
        }
        i = 0;
        while(i < ransomNote.length()) {
            char currentChar = ransomNote.charAt(i);
            if(!map.containsKey(currentChar)) {
                return false;
            }
            else {
                if(map.get(currentChar) == 0) {
                    return false;
                }
                map.put(currentChar, map.get(currentChar) - 1);
                i++;
            }
        }
        return true;
    }
}
