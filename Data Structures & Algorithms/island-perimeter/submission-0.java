class Solution {

    boolean[][] memo;

    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        memo = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    return f(grid, i, j);
                }
            }
        }
        return 0;

    }

    // 这个格子有几条算周长的边
    int f(int[][] grid, int i, int j) {
        if(i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] == 0) return 1;
        if(memo[i][j]) return 0;
        memo[i][j] = true;
        return f(grid, i - 1, j) + f(grid, i + 1, j) + f(grid, i, j - 1) + f(grid, i, j + 1);
        
    }


}