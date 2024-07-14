import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        if(s.isEmpty() || s.length() % 2 != 0)
            return false;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(stack.isEmpty()) {
                if(c == ')' || c == '}' || c == ']')
                    return false;
                stack.add(c);
            }
            else {
                if(c == '(' || c == '{' || c == '[')
                    stack.add(c);
                else {
                    char top = stack.peek();
                    if((top == '(' && c == ')') || (top == '{' && c == '}') || (top == '[' && c == ']')) {
                        stack.pop();
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
