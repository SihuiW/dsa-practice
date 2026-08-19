class Solution {
    int N = 0;
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        N = n;
        UF uf = new UF();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] a = points[i];
                int[] b = points[j];
                int dis = Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
                pq.offer(new int[] {i, j, dis});
            }
        }

        int res = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int a = cur[0];
            int b = cur[1];
            int w = cur[2];
            if (uf.union(a, b)) {
                res += w;
            }
        }
        return res;
    }

    class UF {
        int[] parents = new int[N];

        public UF() {
            for (int i = 0; i < N; i++) {
                parents[i] = i;
            }
        }

        int find(int x) {
            if (parents[x] != x) {
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }

        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if (pa == pb) {
                return false;
            }

            parents[pa] = pb;
            return true;
        }
    }
}