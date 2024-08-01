import java.util.HashMap;

public class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");

        if(pattern.length() != words.length)
            return false;
        
        HashMap<Character, String> map = new HashMap<>();
        int i = 0;
        while(i < words.length) {
            if(!map.containsKey(pattern.charAt(i))) {
                if(map.containsValue(words[i])) {
                    return false;
                }
                else {
                    map.put(pattern.charAt(i), words[i]);
                }
            }
            else {
                if(!map.get(pattern.charAt(i)).equals(words[i])) {
                    return false;
                }
            }
            i++;
        }
        return true;
    }
}
