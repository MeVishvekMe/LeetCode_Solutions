public class Solution {
    public int maxArea(int[] height) {
        int max = 0;

        // Left and right pointers
        int left = 0;
        int right = height.length - 1;

        while(left < right) {
            // Calculate the current area and check with the currentMax
            int currentArea = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, currentArea);

            // We need the height to increase if we're decreasing the width of the container
            if(height[left] <= height[right]) {
                left++;
            }
            else {
                right--;
            }
        }

        // Return the max
        return max;
    }
}
