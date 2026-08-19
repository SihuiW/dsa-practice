class Solution {
    

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int res = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && visited[i][j] != true) {
                    res++;
                    f(grid,i,j,visited);
                }
            }
        }
        return res;
    }


    void f(char[][] grid, int i, int j, boolean[][] visited) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }

        if(visited[i][j]) return;
        if(grid[i][j] == '0') return;
        
        visited[i][j] = true;

        f(grid, i - 1, j, visited);
        f(grid, i + 1, j, visited);
        f(grid, i, j + 1, visited);
        f(grid, i, j - 1, visited);


    }
}
