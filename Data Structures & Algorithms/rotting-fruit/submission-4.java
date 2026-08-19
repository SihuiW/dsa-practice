class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] {i, j});
                }
            }
        }

        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int size = q.size();
            res++;
            for (int k = 0; k < size; k++) {
                int[] cur = q.poll();
                for (int[] d : dir) {
                    int i = cur[0] + d[0];
                    int j = cur[1] + d[1];
                    if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length
                        && grid[i][j] == 1) {
                        grid[i][j] = 2;
                        q.offer(new int[] {i, j});
                    }
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return Math.max(0, res - 1);
    }
}
