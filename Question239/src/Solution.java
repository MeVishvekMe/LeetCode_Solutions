import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        // Pointer to track the position in the result array
        int resultArrayPointer = 0;
        // Result array to store the maximum of each sliding window
        int[] resultArray = new int[nums.length - k + 1];

        // Deque to store indices of array elements. The deque helps in maintaining the indices of potential maximums.
        Deque<Integer> deque = new LinkedList<>();

        // Iterate through the array
        for(int i = 0; i < nums.length; i++) {
            // Remove indices of elements that are out of the current window
            if(!deque.isEmpty() && deque.getFirst() < i - k + 1) {
                deque.removeFirst();
            }

            // Remove indices of elements from the back of the deque that are smaller than the current element
            // as they cannot be the maximum in this or any future window.
            while(!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }

            // Add the current element's index to the deque
            deque.addLast(i);

            // Once we have processed at least the first k elements (i >= k - 1),
            // the element at the front of the deque is the maximum for the current window.
            if(i >= k - 1) {
                resultArray[resultArrayPointer++] = nums[deque.getFirst()];
            }
        }

        // Return the result array containing the maximums of each sliding window
        return resultArray;
    }
}