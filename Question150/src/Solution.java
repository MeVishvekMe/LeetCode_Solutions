import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        // Initialize a stack to store intermediate results
        Stack<Integer> stack = new Stack<>();

        // Iterate through each token in the input array
        for (String token : tokens) {
            switch (token) {
                // Handle addition
                case "+" -> {
                    // Pop the top two elements, add them, and push the result
                    stack.push(stack.pop() + stack.pop());
                }
                // Handle subtraction
                case "-" -> {
                    // Pop the top two elements, subtract the second popped element from the first, and push the result
                    int operand2 = stack.pop();
                    int operand1 = stack.pop();
                    stack.push(operand1 - operand2);
                }
                // Handle multiplication
                case "*" -> {
                    // Pop the top two elements, multiply them, and push the result
                    stack.push(stack.pop() * stack.pop());
                }
                // Handle division
                case "/" -> {
                    // Pop the top two elements, divide the first popped element by the second, and push the result
                    int operand2 = stack.pop();
                    int operand1 = stack.pop();
                    stack.push(operand1 / operand2);
                }
                // Handle numbers (default case)
                default -> {
                    // Parse the token as an integer and push it onto the stack
                    stack.push(Integer.parseInt(token));
                }
            }
        }

        // After processing all tokens, the result will be the only element left in the stack
        return stack.pop();
    }
}