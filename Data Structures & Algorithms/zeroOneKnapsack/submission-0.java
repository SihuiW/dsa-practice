class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int n = profit.size();
        int[][] pair = new int[n][2];
        for(int i = 0; i < n; i++) {
            pair[i] = new int[]{weight.get(i), profit.get(i)};
        }

        int[] dp = new int[capacity + 1];

        for(int[] p: pair) {
            for(int i = capacity; i >= p[0]; i--) {
                dp[i] = Math.max(dp[i], dp[i - p[0]] + p[1]);
            }
        }
        return dp[capacity];

    }
}
