class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            int cur = p[0];
            int pre = p[1];
            graph.get(pre).add(cur);
            indegree[cur]++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int c: graph.get(cur)) {
                indegree[c]--;
                if(indegree[c] == 0) {
                    q.offer(c);
                }
            }
        }

        for(int i: indegree) {
            if(i != 0) return false;
        }
        return true;
    }
}
