import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> indicesStack = new Stack<>(); // Stack to store indices of temperatures

        // Iterate from the last day to the first day
        for (int i = n - 1; i >= 0; i--) {
            // Pop indices of temperatures that are less than or equal to the current day's temperature
            while (!indicesStack.isEmpty() && temperatures[indicesStack.peek()] <= temperatures[i]) {
                indicesStack.pop();
            }
            // Calculate the difference if there's a warmer day, otherwise 0
            result[i] = indicesStack.isEmpty() ? 0 : indicesStack.peek() - i;
            // Push the current index onto the stack
            indicesStack.push(i);
        }

        return result;
    }
}