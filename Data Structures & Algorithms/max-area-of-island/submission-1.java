class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int max = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    max = Math.max(max, f(grid, i, j));
                }
            }
        }
        return max;
    }

    int f(int[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return 0;
        }
        if(grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        return 1 + f(grid, i + 1, j) + f(grid, i, j + 1) + f(grid, i - 1, j) + f(grid, i, j - 1);

        
        
    }

}
