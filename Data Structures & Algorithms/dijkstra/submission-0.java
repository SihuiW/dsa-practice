class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            map.put(i, -1);
        }
        for(List<Integer> pair: edges) {
            int cost = pair.get(2);
            int from = pair.get(0);
            int to = pair.get(1);
            graph.get(from).add(new int[]{to, cost});
        }

        pq.add(new int[]{src, 0});
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], d = cur[1];
            if (map.get(u) != -1 && map.get(u) < d) continue;
            map.put(u, d);
            for(int[] next: graph.get(u)) {
                int v = next[0], weight = next[1];
                if (map.get(v) == -1 || d + weight < map.get(v)) {
                    map.put(v, d + weight);
                    pq.add(new int[]{v, d + weight});
                }
            }
        }
        return map;
    }  
}