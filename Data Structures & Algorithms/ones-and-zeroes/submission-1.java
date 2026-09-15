class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int[] set = f(s);
            for (int i = m; i >= set[0]; i--) {
                for (int j = n; j >= set[1]; j--) {
                    dp[i][j] = Math.max(dp[i - set[0]][j - set[1]] + 1, dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }

    int[] f(String s) {
        int one = 0;
        int zero = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                zero++;
            } else {
                one++;
            }
        }
        return new int[] {zero, one};
    }
}