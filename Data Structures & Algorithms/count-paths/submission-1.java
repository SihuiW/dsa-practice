class Solution {
    // f()定义：到ij这个点有几种方式
    // memo代表走到ij有几种方式
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return f(m - 1, n - 1, memo);
    }

    int f(int i, int j, int[][] memo) {
        if(i < 0 || j < 0) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        if(i == 0 && j == 0) {
            return memo[i][j] = 1;
        }
        memo[i][j] = f(i - 1, j, memo) + f(i, j - 1, memo);
        return memo[i][j];
    }
}
