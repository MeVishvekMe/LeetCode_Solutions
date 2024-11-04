class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for(int num : nums) {
            // nums should have minimum of 2 elements, that's why put the codition k < 2.
            // we don't know if we've put duplicate elements or distinct elements in the last 2 indices
            // so we compare the current element with k - 2 element.
            if(k < 2 || nums[k - 2] < num) {
                nums[k++] = num;
            }
        }
        return k;
    }
}