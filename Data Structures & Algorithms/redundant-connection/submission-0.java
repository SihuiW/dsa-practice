class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] nodes = new int[edges.length + 1];
        for(int i = 1; i < nodes.length; i++) {
            nodes[i] = i;
        }

        int[] res = new int[2];

        for(int[] edge: edges) {
            int a = edge[0], b = edge[1];
            if(find(nodes, a) == find(nodes, b)) {
                res[0] = a;
                res[1] = b;
            } else {
                union(nodes, a, b);
            }
        }

        return res;
    }

    // 一路找它连着谁
    int find(int[] nodes, int x) {
        if(nodes[x] != x) {
            return find(nodes, nodes[x]);
        }
        return x;
    }

    // 把这俩点连一起
    void union(int[] nodes, int a, int b) {
        nodes[find(nodes, a)] = find(nodes, b);
    }
}
