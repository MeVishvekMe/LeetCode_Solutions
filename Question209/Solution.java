public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        while(right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(result, (right - left) + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return (result == Integer.MAX_VALUE) ? 0 : result;
    }
}
