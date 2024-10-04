import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        int left = 0;
        while(left < path.length()) {
            while(left < path.length() && path.charAt(left) == '/') {
                left++;
            }
            int right = left;
            while(right + 1 < path.length() && path.charAt(right + 1) != '/') {
                right++;
            }
            if(left < path.length() && right < path.length()) {
                String subString = path.substring(left, right + 1);
                if(subString.equals("..")) {
                    if(!stack.isEmpty()) {
                        stack.pop();
                    }
                }
                else if(subString.equals(".")) {
                    // Do nothing, ignore the "."
                }
                else {
                    stack.push(subString);
                }
            }
            left = right + 1;
        }
        if(stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for(String dir : stack) {
            sb.append("/").append(dir);
        }
        return sb.toString();
    }
}
