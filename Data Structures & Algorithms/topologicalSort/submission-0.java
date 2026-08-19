class Solution {
    public List<Integer> topologicalSort(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] e: edges) {
            int from = e[0];
            int to = e[1];
            graph.get(from).add(to);
            indegree[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            list.add(curr);
            for(int neighbor : graph.get(curr)) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return list.size() == n ? list : new ArrayList<>();
    }
}