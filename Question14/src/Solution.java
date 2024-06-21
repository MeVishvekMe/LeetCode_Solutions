public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs[0].isEmpty())
            return "";
        String result = strs[0];
        int j = 0;
        int i = 1;
        while(i < strs.length) {
            while(j < strs[i].length() && j < result.length()) {
                if(result.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
                j++;
            }
            if(j == 0) {
                return "";
            }
            result = result.substring(0, j);
            j = 0;
            i++;
        }
        return result;
    }
}
