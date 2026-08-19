class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int[] p: prerequisites) {
            int from = p[1];
            int to = p[0];
            graph.get(from).add(to);
            indegree[to]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        int[] res = new int[numCourses];
        int idx = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            res[idx++] = cur;
            for(int next: graph.get(cur)) {
                indegree[next]--;
                if(indegree[next] == 0) {
                    q.add(next);
                }
            }
        }
        return idx == numCourses ? res : new int[0];
    }
}
