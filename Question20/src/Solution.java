import java.util.Stack;

public class Solution {
    // Function to check if the given string of brackets is valid
    public boolean isValid(String s) {
        // If the string length is odd, it cannot be valid
        if (s.length() % 2 != 0) {
            return false;
        }

        // Stack to keep track of opening brackets
        Stack<Character> stack = new Stack<>();

        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // If the character is an opening bracket, push it onto the stack
            if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
                stack.push(currentChar);
            }
            // If the character is a closing bracket, check for a matching opening bracket
            else if (currentChar == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop(); // Pop the matching opening bracket from the stack
            }
            else if (currentChar == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop(); // Pop the matching opening bracket from the stack
            }
            else if (currentChar == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop(); // Pop the matching opening bracket from the stack
            }
            // If none of the above conditions are met, the string is invalid
            else {
                return false;
            }
        }

        // If the stack is empty, all brackets are matched; otherwise, it's invalid
        return stack.isEmpty();
    }
}
