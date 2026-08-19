class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] p: prerequisites) {
            int cur = p[0];
            int pre = p[1];
            graph.get(pre).add(cur);
            indegree[cur]++;
        }

        Deque<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < graph.size(); i++) {
            if(indegree[i] == 0) q.offer(i);
        }
        int[] res = new int[numCourses];
        int idx = 0;
        int cnt = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next: graph.get(cur)) {
                indegree[next]--;
                if(indegree[next] == 0) {
                    q.offer(next);
                }
            }
            cnt++;
            res[idx++] = cur;
        }
        if(cnt != numCourses) return new int[0];
        return res;
    }
}
