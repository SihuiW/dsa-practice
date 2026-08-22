class Solution {

    class UF {
        int[] parent;
        
        public UF(int n) {
            parent = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        private int find(int x) {
            if(parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        private boolean union(int a, int b) {
            int ra = find(a), rb = find(b);
            if(ra == rb) return false;
            parent[rb] = ra;
            return true;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new ArrayList<>();
        UF uf = new UF(points.length);
        for(int i = 0; i < points.length; i++) {
            for(int j = i + 1; j < points.length; j++) {
                int[] a = points[i];
                int[] b = points[j];
                int w = Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
                edges.add(new int[]{i, j, w});
            }
        }
        int res = 0;
        Collections.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
        for(int[] e: edges) {
            int a = e[0];
            int b = e[1];
            if(uf.union(a, b)) {
                res += e[2];
            }
        }
        return res;
    }
}
