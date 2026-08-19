class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(List<Integer> e: edges) {
            int from = e.get(0);
            int to = e.get(1);
            int w = e.get(2);
            graph.get(from).add(new int[]{to, w});
            graph.get(to).add(new int[]{from, w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        Set<Integer> visited = new HashSet<>();
        int res = 0;

        pq.offer(new int[]{0, 0});
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[1];
            int w = cur[0];
            
            if(visited.contains(node)) continue;
            visited.add(node);
            res += w;
            for(int[] next: graph.get(node)) {
                int to = next[0];
                int cost = next[1];
                pq.offer(new int[]{cost, to});
            }
            
        }
        if(visited.size() != n) return -1;
        return res;
    }
}    
