public class Solution {
  public boolean canJump(int[] nums) {

    // Declare i and goal
    int i = nums.length - 2;
    int goal = nums.length - 1;

    // Keep shifting goal if i + nums[i] >= goal
    while(i > -1) {
      if(i + nums[i] >= goal) {
        goal = i;
      }
      i--;
    }

    // If goal == 0 return true
    return goal == 0;
  }
}
