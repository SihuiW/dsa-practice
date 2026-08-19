class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
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
            res = Math.max(res, use[i]);  // 关键：取最大值
        }

        return res;
    }

    void f(List<int[]>[] graph, int k, int[] use) {
        for (int[] target : graph[k]) {
            int node = target[0];
            int cost = target[1];

            int newTime = use[k] + cost;  // 关键：累计时间

            if (newTime < use[node]) {
                use[node] = newTime;
                f(graph, node, use);
            }
        }
    }
}
