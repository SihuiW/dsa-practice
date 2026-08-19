class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for(int[] e: edges) {
            union(parent, rank, e[0], e[1]);
        }

        Set<Integer> res = new HashSet<>();
        for(int i = 0; i < parent.length; i++) {
            res.add(find(parent, i));
        }

        return res.size();

        
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
            rank[pa] +=rank[pb];
        }
        return true;
    }

    
}
