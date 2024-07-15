import java.util.Arrays;

public class Solution {
  public int removeDuplicates(int[] nums) {
    int i = 0;
    int k = 0;
    int val = nums[0];
    int count = 0;
    while(i < nums.length) {
      if(nums[i] == val) {
        if(count > 1) {
          i++;
          continue;
        }
        nums[k] = nums[i];
        k++;
        count++;
        i++;
      }
      else {
        val = nums[i];
        count = 0;
      }
    }
    return k;
  }
}