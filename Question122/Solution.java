public class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int result = 0;
        int sum = 0;
        int i = 0;
        while(i < prices.length) {
            if(prices[i] - prices[buy] > sum) {
                sum = prices[i] - prices[buy];
            }
            if(prices[i] < prices[buy]) {
                buy = i;
            }
            if((i + 1) < prices.length && prices[i + 1] < prices[i]) {
                buy = i + 1;
                i += 2;
                result += sum;
                sum = 0;
                continue;
            }
            i++;
        }
        if(sum != 0) {
            result += sum;
        }
        return result;
    }
}
