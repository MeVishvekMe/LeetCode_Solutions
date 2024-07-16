class Solution {
  public void rotate(int[] nums, int k) {

    // converting k to its original value
    // k = 8 is equal to k = 1
    k = k % nums.length;

    // reversing whole array
    reverse(0, nums.length - 1, nums);

    // reversing the first k elements
    reverse(0, k - 1, nums);

    // reversing the remaining elements
    reverse(k, nums.length - 1, nums);

  }

  public void reverse(int i, int j, int[] nums) {
    while(i < j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
      i++;
      j--;
    }
  }
}