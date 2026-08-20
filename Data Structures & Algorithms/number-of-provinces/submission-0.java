class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int res = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            q.offer(i);
            visited[i] = true;
            while(!q.isEmpty()) {
                int cur = q.poll();
                for(int j = 0; j < n; j++) {
                    if(isConnected[cur][j] == 1 && !visited[j]) {
                        q.offer(j);
                        visited[j] = true;
                    }
                }
            }
            res++;
        }
        return res;
    }

}