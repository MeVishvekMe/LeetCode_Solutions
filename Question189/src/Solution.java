public class Solution {
  public void rotate(int[] nums, int k) {

    // converting k to its true value
    // k = 8 is equal to k = 1
    int div = k / nums.length;
    if(div > 0) {
      k = k - (div * nums.length);
    }

    // storing the (nums.length - k) elements of nums array in a temp array
    int[] tempArr = new int[nums.length - k];
    int i = 0;
    while(i < tempArr.length) {
      tempArr[i] = nums[i];
      i++;
    }

    // taking the elements from kth index to last, and placing them on first
    i = 0;
    while(i < k) {
      nums[i] = nums[nums.length - k + i];
      i++;
    }
    // after kth index, placing all the copied values in array
    i = k;
    int j = 0;
    while(i < nums.length) {
      nums[i] = tempArr[j];
      j++;
      i++;
    }
  }
}
