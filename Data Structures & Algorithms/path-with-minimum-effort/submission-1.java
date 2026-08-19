class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] memo = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        memo[0][0] = 0;
        pq.offer(new int[]{0,0,0});
        
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int ef = cur[0];
            int i = cur[1];
            int j = cur[2];
            
            if (ef > memo[i][j]) continue;
            
            for (int[] d : dirs) {
                int ni = i + d[0];
                int nj = j + d[1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                    int edgeDiff = Math.abs(heights[i][j] - heights[ni][nj]);
                    int newEffort = Math.max(ef, edgeDiff);
                    if (newEffort < memo[ni][nj]) {
                        memo[ni][nj] = newEffort;
                        pq.offer(new int[]{newEffort, ni, nj});
                    }
                }
            }
        }
        return memo[m - 1][n - 1];

        
    }
}