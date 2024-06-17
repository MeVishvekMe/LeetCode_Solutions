class Solution {
    public int climbStairs(int n) {
        int one = 1;
        int two = 1;
        int i = n;
        while(i != 1) {
            int temp = one;
            one = one + two;
            two = temp;
            i--;
        }
        return one;
    }

}
