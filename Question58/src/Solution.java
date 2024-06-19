public class Solution {
    public int lengthOfLastWord(String s) {
        int result = 0;
        int i = s.length() - 1;
        while(i >= 0) {
            if(s.charAt(i) != ' ') {
                result++;
                if(i - 1 >= 0 && s.charAt(i-1) == ' ') {
                    break;
                }
            }
            i--;
        }
        return result;
    }
}
