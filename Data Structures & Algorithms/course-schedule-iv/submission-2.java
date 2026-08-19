class Solution {

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        List<Integer>[] graph = new List[numCourses];
        
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] pair: prerequisites) {
            graph[pair[1]].add(pair[0]);
        }
        for(int[] q: queries) {
            int u = q[0];
            int v = q[1];
            boolean[] visited = new boolean[numCourses];
            res.add(dfs(graph, u, v, visited));
        }
        return res;
    }

    //是否存在u
    boolean dfs(List<Integer>[] graph, int u, int v, boolean[] visited) {
       if(v == u) return true;
       if(visited[v]) return false;
       visited[v] = true;
       for(int c: graph[v]) {
          if(dfs(graph, u, c, visited)) {
            return true;
          }
       }
       return false;
       
       

    }
}