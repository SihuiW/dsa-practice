class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int res = 0;
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] pairs: edges) {
            int from = pairs[0];
            int to = pairs[1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            f(graph, i, -1, visited);
            res++;
            
        }
        return res;
    }

    void f(List<List<Integer>> graph, int i, int pre, boolean[] visited) {
        if(visited[i]) return;
        visited[i] = true;
        for(int n: graph.get(i)) {
            if(n == pre) continue;
            f(graph, n, i, visited);
        }
    }
}
