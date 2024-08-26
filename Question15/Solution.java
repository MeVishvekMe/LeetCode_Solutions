import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        while(i < nums.length - 2) {
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];
            while(left < right) {
                int sum = nums[left] + nums[right];
                if(sum > target) {
                    right--;
                }
                else if(sum < target) {
                    left++;
                }
                else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(nums[right]);
                    list.add(nums[i]);
                    result.add(list);
                    right--;
                    while(right > -1 && nums[right + 1] == nums[right]) {
                        right--;
                    }
                    left++;
                    while(left < nums.length && nums[left - 1] == nums[left]) {
                        left++;
                    }
                }
            }
            i++;
            while(i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
        }
        return result;
    }
}
