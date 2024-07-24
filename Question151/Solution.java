public class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        int start = -1;
        int end = -1;
        while(i > -1) {
            // If a non-space character found and end is not at some index then put end = i
            if(s.charAt(i) != ' ' && end == -1) {
                end = i;
            }

            // If found a space means word is finished or if start point of String is found
            // Insert start-end sub-string into the StringBuilder with a space
            if(((i - 1) == -1 || s.charAt(i - 1) == ' ') && end != -1) {
                start = i;
                sb.append(s.substring(start, end + 1));
                sb.append(" ");
                end = -1;
                start = -1;
            }
            i--;
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
        
    }
}
