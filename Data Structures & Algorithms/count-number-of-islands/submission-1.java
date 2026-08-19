class Solution {
    

    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    res++;
                    f(grid,i,j);
                }
            }
        }
        return res;
    }


    void f(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }

        if(grid[i][j] == '0') return;
        
        grid[i][j] = '0';

        f(grid, i - 1, j);
        f(grid, i + 1, j);
        f(grid, i, j + 1);
        f(grid, i, j - 1);


    }
}
