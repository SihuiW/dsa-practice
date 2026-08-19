class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0});

        int res = 0;
        int count = 0;

        while (!pq.isEmpty() && count < n) {
            int[] cur = pq.poll();
            int cost = cur[0];
            int idx = cur[1];

            if (visited[idx]) {
                continue;
            }

            visited[idx] = true;
            res += cost;
            count++;

            for (int next = 0; next < n; next++) {
                if (!visited[next]) {
                    int dis = Math.abs(points[idx][0] - points[next][0])
                            + Math.abs(points[idx][1] - points[next][1]);

                    pq.offer(new int[]{dis, next});
                }
            }
        }

        return res;
    }
}