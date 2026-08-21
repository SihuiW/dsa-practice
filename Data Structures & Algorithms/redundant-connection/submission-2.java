class Solution {
    class UF {
        int[] parent;
        int[] rank;

        public UF (int n) {
            parent = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
            rank = new int[n];
        }

        private int find(int x) {
            if(parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        private boolean union(int a, int b) {
            int ra = find(a);
            int rb = find(b);
            if(ra == rb) return false;
            if(rank[ra] < rank[rb]) {
                parent[ra] = rb;
            } else if(rank[ra] > rank[rb]) {
                parent[rb] = ra;
            } else {
                parent[rb] = ra;
                rank[ra]++;
            }
            return true;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        UF uf = new UF(edges.length + 1);
        int[] res = new int[0];
        for(int[] e: edges) {
            int a = e[0];
            int b = e[1];
            if(!uf.union(a, b)) {
                res = e;
            }
        }
        return res;
    }
}
