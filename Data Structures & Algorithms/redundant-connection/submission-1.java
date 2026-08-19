class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for(int[] edge: edges) {
            int a = edge[0];
            int b = edge[1];
            if(!union(parent, rank, a, b)) {
                return new int[]{edge[0], edge[1]};
            }
        }
        return new int[0];


    }

    int find(int[] parent, int x) {
        if(parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    boolean union(int[] parent, int[] rank, int a, int b) {
        int pa = find(parent, a);
        int pb = find(parent, b);
        if(pa == pb) return false;

        if(rank[pa] < rank[pb]) {
            parent[pa] = pb;
            rank[pb] += rank[pa];
        } else {
            parent[pb] = pa;
            rank[pa] += rank[pb];
        }
        return true;
    }


}
