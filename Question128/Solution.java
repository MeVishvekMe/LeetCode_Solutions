import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {    
        HashSet<Integer> set = new HashSet<>();
        int i = 0;
        while(i < nums.length) {
            set.add(nums[i]);
            i++;
        }
        i = 0;
        int count = 0;
        int result = 0;
        while(i < nums.length) {
            if(set.contains(nums[i])) {
                set.remove(nums[i]);
                count = 1;
                int front = nums[i];
                int back = nums[i];
                while(set.contains(front + 1)) {
                    set.remove(front + 1);
                    count++;
                    front++;
                }
                while(set.contains(back - 1)) {
                    set.remove(back - 1);
                    count++;
                    back--;
                }
                if(count > result) {
                    result = count;
                }
            }
            i++;
        }
        return result;
    }
}