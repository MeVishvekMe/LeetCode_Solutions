import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        int i = 0;
        int j = 0;
        while(j < nums.length) {
            if(j + 1 < nums.length && nums[j] + 1 == nums[j + 1]) {
                j++;
            }
            else {
                if(i == j) {
                    s.append(nums[i]);
                    result.add(s.toString());
                }
                else {
                    s.append(nums[i]).append("->").append(nums[j]);
                    result.add(s.toString());
                }
                s.delete(0, s.length());
                j++;
                i = j;
            }
        }
        return result;
    }
}
