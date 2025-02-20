class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array to minimize binary search complexity
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        int total = nums1.length + nums2.length;  // Total length of both arrays
        int half = total / 2;  // Halfway point for partitioning
        int low = 0;
        int high = nums1.length;  // Binary search range within the smaller array

        while (low <= high) {
            int mid = (low + high) / 2;  // Mid index for nums1 partition
            int remaining = half - mid;  // Corresponding partition index in nums2

            // Edge cases: Handle out-of-bounds by using min/max values
            int n1Left = mid > 0 ? nums1[mid - 1] : Integer.MIN_VALUE;  // Left max of nums1
            int n1Right = mid < nums1.length ? nums1[mid] : Integer.MAX_VALUE;  // Right min of nums1
            int n2Left = remaining > 0 ? nums2[remaining - 1] : Integer.MIN_VALUE;  // Left max of nums2
            int n2Right = remaining < nums2.length ? nums2[remaining] : Integer.MAX_VALUE;  // Right min of nums2

            // Check if partition is correct
            if (n1Left <= n2Right && n2Left <= n1Right) {
                // If total length is odd, return the middle element
                if (total % 2 != 0) {
                    return Math.min(n1Right, n2Right);
                }
                // If total length is even, return the average of the two middle elements
                return (Math.max(n1Left, n2Left) + Math.min(n1Right, n2Right)) / 2.0;
            }
            // If partition is incorrect, adjust binary search range
            else if (n1Left > n2Right) {
                high = mid - 1;  // Move left in nums1
            }
            else {
                low = mid + 1;  // Move right in nums1
            }
        }
        return -1;  // Return -1 if no valid median is found (should not happen)
    }
}
