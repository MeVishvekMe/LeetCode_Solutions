import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length; // Get the number of bars in the histogram
        int maxArea = 0; // Variable to store the maximum area found
        Stack<Integer> stack = new Stack<>(); // Stack to keep track of indices of histogram bars

        // Iterate through all bars, including an extra iteration for handling remaining bars in stack
        for (int i = 0; i <= n; i++) {
            // Process the stack when current height is smaller than the height at stack top
            // or when we have reached the end of the heights array
            while (!stack.isEmpty() &&
                    (i == n || heights[stack.peek()] >= heights[i])) {
                int height = heights[stack.pop()]; // Get the height of the bar at stack top
                // Compute the width of the rectangle with the popped height
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                // Update the maximum area
                maxArea = Math.max(maxArea, height * width);
            }
            // Push the current index to the stack
            stack.push(i);
        }
        return maxArea; // Return the maximum rectangular area found
    }
}
