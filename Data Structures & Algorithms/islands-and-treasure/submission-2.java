class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        // 所有宝箱入队，从宝箱开始向四周延申
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for(int[] d: dir) {
                int nx = x + d[0], ny = y + d[1];
                if(nx < 0 || ny < 0 || nx >= m || ny >= n || grid[nx][ny] != 2147483647) {
                    continue;
                }
                grid[nx][ny] = grid[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
    }
}
