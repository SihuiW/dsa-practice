class Solution {
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] {0, 0, 0});
        int m = heights.length, n = heights[0].length;
        int[][] effort = new int[m][n];
        for (int[] row : effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        effort[0][0] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int e = cur[0];
            int i = cur[1];
            int j = cur[2];
            if (e > effort[i][j]) continue;
            if (i == m - 1 && j == n - 1)
                return e;
            for (int[] d : dir) {
                int ni = i + d[0];
                int nj = j + d[1];
                if (ni < 0 || ni >= m || nj < 0 || nj >= n) {
                    continue;
                }
                int diff = Math.abs(heights[ni][nj] - heights[i][j]);
                int newE = Math.max(e, diff);

                if (newE < effort[ni][nj]) {
                    effort[ni][nj] = newE;
                    pq.offer(new int[]{newE, ni, nj});
                }
            }
        }

        return 0;
    }
}