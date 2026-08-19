class Solution {

    int res = 0;
    boolean[] visited;
    
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> graph = new ArrayList<>();
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] e: edges) {
            int from = e[0];
            int to = e[1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        dfs(graph, 0, hasApple);
        return res;
    }

    boolean dfs(List<List<Integer>> list, int idx, List<Boolean> hasApple) {
        visited[idx] = true;
        boolean childHasApple = false;
        for(int child: list.get(idx)) {
            if(!visited[child]) {
                if (dfs(list, child, hasApple)) childHasApple = true;
            }
        }
        
        boolean currentNeedsPath = hasApple.get(idx) || childHasApple;
        if(currentNeedsPath && idx != 0) res += 2;
        return currentNeedsPath;
    }
}