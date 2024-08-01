import java.util.HashSet;

public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        int sum = n;
        int i = n;
        while(sum != 1) {
            sum = 0;
            while(i != 0) {
                sum += ((i % 10) * (i % 10));
                i /= 10;
            }
            if(set.contains(sum)) {
                return false;
            }
            set.add(sum);
            i = sum;
        }
        return true;
    }
}