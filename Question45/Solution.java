public class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }
        int low = 0;
        int high = 0;
        int jumps = 0;
        while(high < nums.length - 1) {
            int i = low;
            int max = i + nums[low];
            while(i <= high) {
                if((i + nums[i]) >= max) {
                    max = i + nums[i];
                }
                i++;
            }
            low = high + 1;
            high = max;
            jumps++;
        }
        return jumps;
    }
}