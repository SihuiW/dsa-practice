class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for(int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(prices[i] - minPrice, maxProfit);
            minPrice = Math.min(prices[i], minPrice);
        }
        return maxProfit;
    }
}
