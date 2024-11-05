class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int profit = Integer.MIN_VALUE;
        int sell = 0;
        while(sell < prices.length) {
            profit = Math.max(profit, prices[sell] - prices[buy]);
            if(prices[sell] < prices[buy]) {
                buy = sell;
            }
            sell++;
        }
        return profit;
    }
}