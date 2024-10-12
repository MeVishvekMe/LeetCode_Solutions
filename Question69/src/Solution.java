public class Solution {
    public int mySqrt(int x) {
        // Create left and right pointers for binary search
        int left = 0;
        int right = (x / 2) + 1; // For sure sqrt of a number cannot be greater than half of the number

        while(left <= right) {
            int mid = left + (right - left) / 2; // Avoiding possible overflow situation
            long midSquared = (long) mid * mid; // Square can overflow so long is the datatype needed

            // If square of the mid is equals to x then return mid.
            if(midSquared == x) {
                return mid;
            }
            else if(midSquared > x) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        // Right pointer will always end up being the nearest sqrt of x.
        return right;
    }
}
