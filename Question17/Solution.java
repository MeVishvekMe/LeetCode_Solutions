import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return new ArrayList<>();
        }
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> result = new ArrayList<>();
        helper(map, digits, 0, result, null);
        return result;
    }

    public void helper(HashMap<Character, String> map, String digits, int level, List<String> result, StringBuilder sb) {
        if(level == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String alphas = map.get(digits.charAt(level));
        int i = 0;
        while(i < alphas.length()) {
            if(level == 0) {
                StringBuilder builder = new StringBuilder();
                builder.append(alphas.charAt(i));
                helper(map, digits, level + 1, result, builder);
                builder.charAt(level);
            }
            else {
                sb.append(alphas.charAt(i));
                helper(map, digits, level + 1, result, sb);
                sb.deleteCharAt(level);
            }
            i++;
        }
    }
}
