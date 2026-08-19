class Solution {
    public int orangesRotting(int[][] grid) {
        int step = 0;
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;

        while(!q.isEmpty()) {
            int size = q.size();
            boolean rottedAny = false;
            for(int i = 0; i < size; i++) {
                int[] rotten = q.poll();
                if (f(rotten[0], rotten[1], q, m, n, grid)) rottedAny = true;
            }
            if (rottedAny) step++;
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) return -1;
            }
        }

        return step;
    }

    int[][] dir = {{1,0}, {0,1}, {-1,0},{0,-1}};

    boolean f(int i, int j, Queue<int[]> q, int m, int n, int[][] grid) {
        boolean changed = false;
        for(int[] d: dir) {
            int a = i + d[0];
            int b = j + d[1];
            if(a >= m || b >= n || a < 0 || b < 0 || grid[a][b] != 1) continue;
            grid[a][b] = 2;
            q.add(new int[]{a, b});
            changed = true;
        }
        return changed;
    }
}