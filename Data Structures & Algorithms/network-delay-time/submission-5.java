class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int[] t : times) {
            int ui = t[0];
            int vi = t[1];
            int ti = t[2];
            graph[ui].add(new int[]{vi, ti});
        }

        pq.offer(new int[]{k, 0});
        dist[k] = 0;

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int w = cur[1];
            if(w > dist[node]) continue;
            for(int[] next: graph[node]) {
                if(w + next[1] < dist[next[0]]) {
                    dist[next[0]] = w + next[1];
                    pq.offer(new int[]{next[0], dist[next[0]]});
                }
            }
        }

        int res = 0;

        for(int i = 1; i <= n; i++) {
            if(dist[i] == Integer.MAX_VALUE) return -1;
            res = Math.max(res, dist[i]);
        }
        return res;
    }
}