public class Wa {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int k = 0;
        while(i < nums.length) {
            if(nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
            i++;
        }
        return k;
    }
}
