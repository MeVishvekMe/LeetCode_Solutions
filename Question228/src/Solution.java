import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(j < nums.length) {
            if(j + 1 < nums.length && nums[j] + 1 == nums[j + 1]) {
                j++;
            }
            else {
                if(i == j) {
                    result.add(nums[i] + "");
                }
                else {
                    result.add(nums[i] + "->" + nums[j]);
                }
                j++;
                i = j;
            }
        }
        return result;
    }
}
