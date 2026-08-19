class Solution {
    public boolean makesquare(int[] matchsticks) {
        int total = 0;
        for (int m : matchsticks) total += m;

        if (total % 4 != 0) return false;

        int side = total / 4;

        for (int m : matchsticks) {
            if (m > side) return false;
        }

        Arrays.sort(matchsticks);

        int[] edges = new int[4];

        return dfs(0, matchsticks, edges, side);
    }

    private boolean dfs(int index, int[] matchsticks, int[] edges, int side) {
        if (index == matchsticks.length) {
            return edges[0] == side &&
                   edges[1] == side &&
                   edges[2] == side &&
                   edges[3] == side;
        }

        int cur = matchsticks[matchsticks.length - 1 - index];

        for (int i = 0; i < 4; i++) {
            if (edges[i] + cur > side) continue;

            edges[i] += cur;

            if (dfs(index + 1, matchsticks, edges, side)) {
                return true;
            }

            edges[i] -= cur;
        }

        return false;
    }
}