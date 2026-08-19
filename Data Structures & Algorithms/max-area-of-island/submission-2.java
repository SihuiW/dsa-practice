class Solution {
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    int area = f(grid, i, j);
                    res = Math.max(res, area);
                }
            }
        }
        return res;
    }

    int f(int[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;
        int res = 1;
        for(int[] d: dir) {
            res += f(grid, i + d[0], j + d[1]);
        }
        return res;
    }
}
