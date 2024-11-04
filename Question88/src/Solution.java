class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Put a pointer to the end of nums1.
        int j = m + n - 1;

        // Decrease the m and n pointers to the end of filled elements.
        m--;
        n--;

        // Loop till n reaches the -1 index, if m reaches the end first, that's fine.
        while(n >= 0) {
            if(m >= 0 && nums1[m] > nums2[n]) {
                nums1[j] = nums1[m];
                m--;
            }
            else {
                nums1[j] = nums2[n];
                n--;
            }
            j--;
        }
    }
}