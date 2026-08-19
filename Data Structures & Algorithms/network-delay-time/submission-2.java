class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 从起点 k 到达节点 i 的当前已知最短时间
        int[] use = new int[n + 1];
        Arrays.fill(use, Integer.MAX_VALUE);
        use[k] = 0;  // 从 k 到自己是 0

        List<int[]>[] graph = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] path : times) {
            int ui = path[0];
            int vi = path[1];
            int ti = path[2];
            graph[ui].add(new int[]{vi, ti});
        }

        f(graph, k, use);

        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (use[i] == Integer.MAX_VALUE) return -1;
            res = Math.max(res, use[i]);
        }

        return res;
    }

    void f(List<int[]>[] graph, int cur, int[] use) {
        for (int[] target : graph[cur]) {
            int node = target[0];
            int cost = target[1];

            // 通过当前边能够到达 node 的时间
            int newTime = use[cur] + cost;

            if (newTime < use[node]) {
                use[node] = newTime;
                f(graph, node, use);
            }
        }
    }
}
