public class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int buy = prices[0];
        int i = 0;
        while(i < prices.length) {
            int cal = prices[i] - buy;
            if(cal > result) {
                result = cal;
            }
            if(prices[i] < buy) {
                buy = prices[i];
            }
            i++;
        }
        return result;
    }
}
