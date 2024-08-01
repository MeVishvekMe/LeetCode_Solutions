import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int i = 0;
        while (i < nums.length) {
            int temp = target - nums[i];
            if (hashMap.containsKey(temp)) {
                return new int[]{hashMap.get(temp), i};
            }
            else {
                hashMap.put(nums[i], i);
            }
            i++;
        }
        return new int[]{};
    }
}