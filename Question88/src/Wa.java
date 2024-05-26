import java.util.Arrays;

public class Wa {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0)
            return;
        int i = 0;
        int j = 0;
        while (i < nums1.length) {
            if (nums1[i] == 0) {
                j = 0;
                while (j < nums2.length) {
                    nums1[i] = nums2[j];
                    j++;
                    i++;
                }
                break;
            }
            if (nums1[i] > nums2[j]) {
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
                while(j + 1 < nums2.length && nums2[j + 1] < nums2[j]) {
                    temp = nums2[j];
                    nums2[j] = nums2[j + 1];
                    j++;
                }
                j = 0;
            }
            i++;
        }
        System.out.println(Arrays.toString(nums1));
    }
}