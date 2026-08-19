class Solution {
    public int arrangeCoins(int n) {
        int l = 1, r = n, res = 0;
        while(l <= r) {
            int m = l + (r - l) / 2;
            long coins = (long)m * (1 + m) / 2;
            if(coins <= n) {
                l = m + 1;
                res = Math.max(res, m);
            } else {
                r = m - 1;
            }
        }
        return res;
    }
}