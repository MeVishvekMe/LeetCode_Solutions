import java.util.Arrays;
import java.util.Stack;

class Solution {

    // Iterative Approach
    public int carFleet(int target, int[] position, int[] speed) {

        // Create a 2D array to pair each car's position and speed
        int[][] pairs = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pairs[i][0] = position[i]; // Store the car's position
            pairs[i][1] = speed[i];   // Store the car's speed
        }

        // Sort the cars by position in descending order (closer to the target comes first)
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));

        // Initialize the fleet count to 1 (at least one fleet exists)
        int fleet = 1;

        // Calculate the time taken by the first car (closest to the target) to reach the target
        double slowestTime = (double) (target - pairs[0][0]) / pairs[0][1];

        // Iterate over the remaining cars
        for (int i = 1; i < pairs.length; i++) {
            // Calculate the time for the current car to reach the target
            double currentTime = (double) (target - pairs[i][0]) / pairs[i][1];

            // If the current car takes longer than the slowestTime,
            // it cannot catch up to the fleet ahead and forms a new fleet
            if (currentTime > slowestTime) {
                fleet++;                // Increment the fleet count
                slowestTime = currentTime; // Update the slowestTime to the current car's time
            }
            // If currentTime <= slowestTime, the current car merges into the existing fleet.
        }

        // Return the total number of fleets
        return fleet;
    }


    // Solution using Stack
    public int carFleetStack(int target, int[] position, int[] speed) {

        // Step 1: Combine position and speed into a single array of pairs.
        // Each pair consists of position and corresponding speed.
        int[][] pairs = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pairs[i][0] = position[i]; // Car's position
            pairs[i][1] = speed[i];   // Car's speed
        }

        // Step 2: Sort the cars by their starting position in descending order.
        // This ensures that we process cars from farthest to closest to the target.
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));

        // Step 3: Use a stack to keep track of the time each car or fleet takes to reach the target.
        Stack<Double> stack = new Stack<>();

        // Step 4: Iterate through the sorted list of cars.
        for (int[] pair : pairs) {
            // Calculate the time for the current car to reach the target.
            double time = (double) (target - pair[0]) / pair[1];
            stack.push(time); // Push the time onto the stack.

            // Check if the top two times on the stack should merge into one fleet.
            // If the current car (on top of the stack) takes less time or the same time
            // as the car below it, they will form a single fleet.
            if (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)) {
                stack.pop(); // Merge the current car with the fleet below it.
            }
        }

        // Step 5: The size of the stack represents the number of fleets.
        return stack.size();
    }
}
