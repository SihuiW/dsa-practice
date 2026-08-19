class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] t: times) {
            int from = t[0];
            int to = t[1];
            int cost = t[2];
            graph.get(from).add(new int[]{to, cost});
        }

        int[] rec = new int[n + 1];
        Arrays.fill(rec, Integer.MAX_VALUE);
        rec[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[1];
            int cost = cur[0];

            if(rec[node] < cost) continue;

            for(int[] next: graph.get(node)) {
                int nxt = next[0];
                int w = next[1];
                if(rec[nxt] > w + cost) {
                    rec[nxt] = w + cost;
                    pq.offer(new int[]{rec[nxt], nxt});
                } 
            }
        }

        int res = 0;
        for(int i = 1; i <= n; i++) {
            if(rec[i] == Integer.MAX_VALUE) return -1;
            res = Math.max(res, rec[i]);
        }

        return res;

    }
}
