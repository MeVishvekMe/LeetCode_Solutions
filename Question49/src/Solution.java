import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Approach would be to iterate every String and sort it
        // Add the sorted String to the HashMap
        // If any anagram will be found then it will end up as same sorted String

        // HashMap for strong String and list of anagrams
        HashMap<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++) {
            // Sort the current String
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String sortedString = Arrays.toString(c);

            // If not found in map then put it and create new List
            if (!map.containsKey(sortedString)) {
                map.put(sortedString, new ArrayList<>());
            }

            // Add the original String to the mapped List
            map.get(sortedString).add(strs[i]);
        }

        // return all the values of HashMap
        return new ArrayList<>(map.values());
    }
}
