class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        
        if(f(graph, 0, -1, visited)) return false;
        
        for(boolean b: visited) {
            if(!b) return false;
        }
        
        return true;
    }

    boolean f(List<List<Integer>> graph, int i, int last, boolean[] visited) {
        if(visited[i]) return true;
        visited[i] = true;
        for(int n: graph.get(i)) {
            if(n == last) continue;
            if(f(graph, n, i, visited)) return true;
        }
        return false;

    }
}
