class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int fresh = 0;
        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while(fresh > 0 && !q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];
                for(int[] d: dir) {
                    int nx = x + d[0];
                    int ny = y + d[1];
                    if(nx < 0 || ny < 0 || nx >= m || ny >= n || grid[nx][ny] == 0 || grid[nx][ny] == 2) continue;
                    grid[nx][ny] = 2;
                    q.offer(new int[]{nx, ny});
                    fresh--;
                }
            }
            time++;
        }
        return fresh == 0 ? time: -1;
    }
}
