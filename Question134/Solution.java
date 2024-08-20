public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int fuel = 0;
        int i = 0;
        int total = 0;
        int current = 0;
        while(i < gas.length) {
            total += (gas[i] - cost[i]);
            fuel += (gas[i] - cost[i]);
            if(fuel < 0) {
                current = i + 1;
                fuel = 0;
            }
            i++;
        }
        return total > 0 ? -1 : current;
    }
}
