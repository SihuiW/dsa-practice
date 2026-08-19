class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(List<Integer> e: edges) {
            int from = e.get(0);
            int to = e.get(1);
            int weight = e.get(2);

            graph.get(from).add(new int[]{to, weight});
        }

        int[] record = new int[n];
        Arrays.fill(record, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        record[src] = 0;
        pq.offer(new int[]{0, src});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int target = cur[1];
            int cost = cur[0];
            if(record[target] < cost) {
                continue;
            }
            for(int[] nei: graph.get(target)) {
                int to = nei[0];
                int w = nei[1];
                if (record[to] > cost + w) {
                    record[to] = cost + w;
                    pq.offer(new int[]{record[to], to});
                }
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(i, record[i] == Integer.MAX_VALUE ? -1 : record[i]);
        }

        return map;
    }  
}
