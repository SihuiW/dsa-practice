class Solution {
    int[][] memo;

    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int n = profit.size();
        memo = new int[n][capacity + 1];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dfs(profit, weight, 0, capacity);
    }

    int dfs(List<Integer> profit, List<Integer> weight, int idx, int capacity) {
        if (idx == profit.size()) {
            return 0;
        }

        if (memo[idx][capacity] != -1) {
            return memo[idx][capacity];
        }

        int notTake = dfs(profit, weight, idx + 1, capacity);

        int take = 0;
        int w = weight.get(idx);
        int p = profit.get(idx);

        if (capacity >= w) {
            take = p + dfs(profit, weight, idx + 1, capacity - w);
        }

        memo[idx][capacity] = Math.max(notTake, take);
        return memo[idx][capacity];
    }
}