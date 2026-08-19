class Solution {
    // 建图
    // 对于每一个数，dfs去找树高
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List[] graph = new List[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] pair: edges) {
            int from = pair[0];
            int to = pair[1];
            graph[from].add(to);
            graph[to].add(from);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int min = n;
        for(int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            int h = dfs(graph, i, -1, visited);
            pq.add(new int[]{i, h});
        }
        
        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty()) {
            int[] p = pq.poll();
            res.add(p[0]);
            if(!pq.isEmpty() && pq.peek()[1] > p[1]) break;
        }
        return res;
    }

    int dfs(List[] graph, int i, int p, boolean[] visited) {
        visited[i] = true;
        int height = 0;
        List<Integer> list = graph[i];
        for(int next: list) {
            if(next != p && !visited[next]) {
                height = Math.max(height, dfs(graph, next, i, visited) + 1);
            }
        }
        return height;


    }





}