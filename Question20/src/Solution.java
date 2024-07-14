import java.util.Stack;

public class Solution {
  public boolean isValid(String s) {
    if (s.isEmpty() || (s.length() % 2 != 0))
      return false;
    Stack<Character> stack = new Stack<>();
    int i = 0;
    while(i < s.length()) {
      if(stack.isEmpty()) {
        if(s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']')
          return false;
        stack.add(s.charAt(i));
        i++;
        continue;
      }
      char current = stack.peek();
      if(s.charAt(i) != giveExit(current)) {
        if(s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']')
          return false;
        else
          stack.add(s.charAt(i));
      }
      else
        stack.pop();
      i++;
    }
    return stack.isEmpty();
  }

  public char giveExit(char c) {
    if(c == '(')
      return ')';
    else if(c == '{')
      return '}';
    else
      return ']';
  }

}
// 40 -> (
// 41 -> )

// 91 -> [
// 93 -> ]

// 123 -> {
// 125 -> }

// ({}[])