class Solution {
    int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};
    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    f(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    void f(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        for(int[] d: dir) {
            f(grid, i + d[0], j + d[1]);
        }
    }
}
