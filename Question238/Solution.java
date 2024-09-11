public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        int[] suf = new int[nums.length];
        pre[0] = 1;
        suf[suf.length - 1] = 1;
        int i = 1;
        while(i < pre.length) {
            pre[i] = pre[i - 1] * nums[i - 1];
            i++;
        }
        
        i = suf.length - 2;
        while(i > -1) {
            suf[i] = suf[i + 1] * nums[i + 1];
            i--;
        }
        int[] result = new int[nums.length];
        i = 0;
        while(i < result.length) {
            result[i] = pre[i] * suf[i];
            i++;
        }
        return result;
    }
}
