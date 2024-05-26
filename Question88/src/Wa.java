public class Wa {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (n == 0) {
            return;
        }
        int i = m + n - 1;

        // ptr1 and ptr2 are the indices of real end numbers of both the arrays.
        int ptr1 = m - 1;
        int ptr2 = n - 1;

        // we are not changing the nums1[ptr1] or nums2[ptr2] because we're never going to compare those elements again
        // eventually the i pointer will come to ptr1, and we're not comparing i.
        while(ptr2 >= 0 && ptr1 >= 0 && m > 0 && n > 0) {
            if (nums1[ptr1] > nums2[ptr2]) {
                nums1[i] = nums1[ptr1];
                ptr1--;
            }
            else {
                nums1[i] = nums2[ptr2];
                ptr2--;
            }
            i--;
        }

        // placing all the remaining elements of the nums2 in nums1
        while(ptr2 >= 0) {
            nums1[i] = nums2[ptr2];
            ptr2--;
            i--;
        }
    }

}