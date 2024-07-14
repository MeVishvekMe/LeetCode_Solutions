import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) // check if the length of the string is an odd number then return false
            return false;
        Stack<Character> stack = new Stack<>(); // create a char stack
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') // check of any opening braces, if there are then push in stack
                stack.push(c);
            else if(c == ')' && !stack.isEmpty() && stack.peek() == '(') // for all the 3 else ifs
                stack.pop();
            else if(c == '}' && !stack.isEmpty() && stack.peek() == '{') // checking if stack.peek is opening brace and c is the corresponding closing brace
                stack.pop();
            else if(c == ']' && !stack.isEmpty() && stack.peek() == '[')
                stack.pop();
            else // if none, then return false including the cases like, ]], })], etc.
                return false;
        }
        return stack.isEmpty();
    }
}
