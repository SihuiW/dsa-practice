class Solution {

    
    Boolean[] visited;
    List<Integer> list = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        visited = new Boolean[numCourses];
        
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] pre: prerequisites) {
            int a = pre[0];
            int b = pre[1];
            graph.get(b).add(a);
        }


        for(int i = 0; i < numCourses; i++) {
            if(visited[i] == null) {
                if(hasCycle(graph, i)) return new int[]{};
            }
        }

        Collections.reverse(list);
        int[] res = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            res[i] = list.get(i);
        }

        return res;


    }

    // 从某个点出发是否有环
    boolean hasCycle(List<List<Integer>> graph, int start) {
        // null是没访问，false是访问中，true是完成访问
        if (visited[start] != null && visited[start] == false) return true;
        if (visited[start] != null && visited[start] == true) return false;
        visited[start] = false;
        List<Integer> nexts = graph.get(start);
        for(int n: nexts) {
            if(hasCycle(graph, n)) return true;
        }
        list.add(start);
        visited[start] = true;
        return false;
    }
}
