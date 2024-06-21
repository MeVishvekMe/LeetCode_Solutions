public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        try {
            int i = 0;
            int j = 0;
            while(true) {
                i = 0;
                char ch = strs[0].charAt(j);
                while(i < strs.length) {
                    if(strs[i].charAt(j) != ch) {
                        return result;
                    }
                    i++;
                }
                result = result + strs[0].charAt(j);
                j++;
            }

        } catch (StringIndexOutOfBoundsException e) {

        }
        return result;
    }
}
