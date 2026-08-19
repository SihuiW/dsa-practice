class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int minBuy = prices[0];
        for(int sell: prices) {
            res = Math.max(res, sell - minBuy);
            minBuy = Math.min(minBuy, sell);
        }
        return res;
    }
}
