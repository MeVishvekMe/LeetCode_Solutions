import java.util.HashMap;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        int i = 0;
        while(i < s.length()) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if(!map.containsKey(sChar)) {
                if(map.containsValue(tChar)) {
                    return false;
                }
                else
                    map.put(sChar, tChar);
            }
            else {
                if(!map.get(sChar).equals(tChar)) {
                    return false;
                }
            }
            i++;
        }
        return true;
    }
}
