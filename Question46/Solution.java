import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    public void helper(int[] nums, int level, List<Integer> list) {
        if(level == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        int i = 0;
        while(i < nums.length) {
            if(nums[i] != 99) {
                list.add(nums[i]);
                int temp = nums[i];
                nums[i] = 99;
                helper(nums, level + 1, list);
                nums[i] = temp;
                list.removeLast();
            }
            i++;
        }
    }
}
