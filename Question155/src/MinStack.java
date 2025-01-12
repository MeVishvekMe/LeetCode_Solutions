import java.util.Stack;

// A class to implement a stack that supports retrieving the minimum element in constant time.
class MinStack {
    // Main stack to store all elements
    Stack<Integer> mainStack;
    // Auxiliary stack to store the minimum values corresponding to the elements in mainStack
    Stack<Integer> minStack;

    // Constructor to initialize the two stacks
    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    // Method to push an element onto the stack
    public void push(int val) {
        mainStack.push(val); // Push the value onto the main stack
        // Push the minimum value onto the minStack
        // If minStack is empty or the current value is smaller than the top of minStack, push the current value
        if (minStack.isEmpty() || minStack.peek() > val) {
            minStack.push(val);
        } else {
            // Otherwise, push the current top of minStack to maintain the minimum value
            minStack.push(minStack.peek());
        }
    }

    // Method to remove the top element from the stack
    public void pop() {
        // Only pop if the mainStack is not empty
        if (mainStack.isEmpty()) return;
        mainStack.pop(); // Remove the top element from the main stack
        minStack.pop();  // Remove the top element from the min stack
    }

    // Method to retrieve the top element of the stack
    public int top() {
        return mainStack.peek(); // Return the top element of the main stack
    }

    // Method to retrieve the minimum element in the stack
    public int getMin() {
        return minStack.peek(); // Return the top element of the min stack, which is the minimum
    }
}
