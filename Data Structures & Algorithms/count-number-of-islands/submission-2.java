class Solution {

    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    res++;
                    f(grid, i, j);
                }
            }
        }
        return res;
    }

    void f(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length ||grid[i][j] != '1') return;
        grid[i][j] = '0';
        for(int[] d: dir) {
            int x = i + d[0];
            int y = j + d[1];
            f(grid, x, y);
        }
        return;
    }
}
