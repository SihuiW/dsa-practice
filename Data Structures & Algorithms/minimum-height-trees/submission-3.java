class Solution {
    // 建图
    // 对于每一个数，dfs去找树高
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return List.of(0);
        List<Integer>[] graph = new List[n];
        int[] degree = new int[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] pair: edges) {
            int from = pair[0];
            int to = pair[1];
            graph[from].add(to);
            graph[to].add(from);
            degree[from]++;
            degree[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) queue.offer(i);
        }

        int remaining = n;
        while (remaining > 2) {
            int size = queue.size();
            remaining -= size;
            for (int i = 0; i < size; i++) {
                int leaf = queue.poll();
                for (int nei : graph[leaf]) {
                    if (--degree[nei] == 1) {
                        queue.offer(nei);
                    }
                }
            }
        }

       return new ArrayList<>(queue);
    }



}