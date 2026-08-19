class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] pair: prerequisites) {
            int course = pair[0];
            int pre = pair[1];
            graph.get(pre).add(course);
        }
        for(int i = 0; i < numCourses; i++) {
            if(f(graph, i, visited)) {
                return false;
            }
        }
        return true;
    }

    boolean f(List<List<Integer>> graph, int i, int[] visited) {
        if(visited[i] == 1) return true;
        if(visited[i] == 2) return false;
        visited[i] = 1;
        for(int c: graph.get(i)) {
            if(f(graph, c, visited)) return true;
        }
        visited[i] = 2;
        return false;
    }
}
