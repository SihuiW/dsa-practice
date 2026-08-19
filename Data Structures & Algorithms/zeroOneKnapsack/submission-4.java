class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int[] dp = new int[capacity + 1];
        for(int i = 0; i < weight.size(); i++) {
            int w = weight.get(i);
            int p = profit.get(i);
            for(int j = capacity; j >= w; j--) {
                dp[j] = Math.max(dp[j], dp[j - w] + p);
            }
        }
        return dp[capacity];
    }
}
