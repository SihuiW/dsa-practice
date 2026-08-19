class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<double[]>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            double pro = succProb[i];
            graph.get(from).add(new double[]{to, pro});
            graph.get(to).add(new double[]{from, pro});
        }
        double[] rec = new double[n];
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare(b[0], a[0]));
        rec[start_node] = 1.0;
        pq.offer(new double[]{1.0, (double)start_node});
        while(!pq.isEmpty()) {
            double[] cur = pq.poll();
            double pro = cur[0];
            int node = (int)cur[1];
            if(rec[node] > pro) continue;

            for(double[] nei: graph.get(node)) {
                int next = (int)nei[0];
                double p = nei[1];
                if(rec[next] < pro * p) {
                    rec[next] = pro * p;
                    pq.offer(new double[]{rec[next], (double)next});
                }
            }
        }

        return rec[end_node];
    }
}