import java.util.HashMap;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        while(i < nums.length) {
            if(map.containsKey(nums[i])) {
                int sub = Math.abs(map.get(nums[i]) - i);
                if(sub <= k) {
                    return true;
                }
                else {
                    map.put(nums[i], i);
                }
            }
            else {
                map.put(nums[i], i);
            }
            i++;
        } 
        return false;
    }
}
