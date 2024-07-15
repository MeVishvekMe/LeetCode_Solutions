import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> result = new ArrayList<>();
    int i = 0;
    while(i < nums.length) {
      int index = Math.abs(nums[i]) - 1;
      if(nums[index] < 0) {
        result.add(index + 1);
      }
      else {
        nums[index] = -nums[index];
      }
      i++;
    }
    return result;
  }
}