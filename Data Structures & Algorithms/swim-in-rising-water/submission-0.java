class Solution {
    public int swimInWater(int[][] grid) {
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int n = grid.length;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] {grid[0][0], 0, 0});
        dist[0][0] = grid[0][0];
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int c = cur[0];
            int i = cur[1];
            int j = cur[2];
            if (c > dist[i][j])
                continue;
            if(i == n - 1 && j == n - 1) return dist[i][j];

            for (int[] d : dir) {
                int ni = i + d[0];
                int nj = j + d[1];
                if (ni < 0 || nj < 0 || ni >= n || nj >= n)
                    continue;

                int nc = Math.max(c, grid[ni][nj]);
                if(nc < dist[ni][nj]) {
                    dist[ni][nj] = nc;
                    pq.offer(new int[]{nc, ni, nj});
                }
            }
        }
        return -1;
    }
}
