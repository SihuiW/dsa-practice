class Solution {

    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int n = points.length;
        boolean[] visited = new boolean[n];
        pq.offer(new int[]{0, 0});
        int res = 0;
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
                        if(visited[cur[0]]) continue;

            visited[cur[0]] = true;
            res += cur[1];
            for(int i = 0; i < n; i++) {
                
                int w = Math.abs(points[cur[0]][0] - points[i][0]) + Math.abs(points[cur[0]][1] - points[i][1]);
                pq.offer(new int[]{i, w});
            }
        }
        return res;
        

    }
}
