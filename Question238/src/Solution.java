public class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Length of the nums array
        int numsLength = nums.length;

        // Array to store all the previous index's multiplication
        int[] preMul = new int[numsLength];
        preMul[0] = 1;
        for(int i = 1; i < preMul.length; i++) {
            preMul[i] = preMul[i - 1] * nums[i - 1];
        }

        // Array to store the next index's multiplication
        int[] postMul = new int[numsLength];
        postMul[numsLength - 1] = 1;
        for(int i = numsLength - 2; i >= 0; i--) {
            postMul[i] = postMul[i + 1] * nums[i + 1];
        }

        // The multiplication of ith index of pre and post array holds the multiplication of every number except for self
        int[] result = new int[numsLength];
        for(int i = 0; i < numsLength; i++) {
            result[i] = preMul[i] * postMul[i];
        }

        // return the result array
        return result;
    }
}
