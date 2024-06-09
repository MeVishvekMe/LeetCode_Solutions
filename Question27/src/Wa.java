public class Wa {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        int k = 0;
        if(nums.length == 1) {
            if (nums[0] == val) {
                return k;
            }
            return ++k;
        }
        while(left < right) {
            while(nums[left] != val) {
                k++;
                left++;
                if (left == nums.length)
                    return k;
            }
            while(nums[right] == val) {
                right--;
                if (right == 0)
                    return k;
            }
            if(left >= right) {
                return k;
            }
            k++;
            nums[left] = nums[right];
            nums[right] = val;
            left++;
        }
        return k;
    }
}
