class Solution {
    boolean isCycle;
    Boolean[] visited;
    List<Integer> list = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new Boolean[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] pair: prerequisites) {
            graph.get(pair[0]).add(pair[1]);
        }
        for(int i = 0; i < numCourses; i++) {
            f(graph, i);
        }

        if(list.size() != numCourses || isCycle) return new int[0];
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    void f(List<List<Integer>> graph, int idx) {
        if(visited[idx] != null) {
            if(visited[idx] == false) isCycle = true;

            return;
        }
        visited[idx] = false;
        for(int course: graph.get(idx)) {
            f(graph, course);
        }
        list.add(idx);
        visited[idx] = true;
    }

}