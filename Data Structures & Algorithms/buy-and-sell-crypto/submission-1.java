class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int res = 0;
        int l = 0, r = l + 1;
        while(r < prices.length) {
            int profit = prices[r] - prices[l];
            res = Math.max(res, profit);
            if(profit <= 0) l = r;
            r++;
        }
        return res;
    }
}
