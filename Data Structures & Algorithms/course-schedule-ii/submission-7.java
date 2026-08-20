class Solution {
    List<Integer> list = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] state = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
        }


        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (!f(graph, i, state)) return new int[0];
            }
        }

        if (list.size() != numCourses)
            return new int[0];
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = list.get(numCourses - 1 - i);
        }
        return res;
    }

    boolean f(List<List<Integer>>graph, int idx, int[] state) {
        if (state[idx] == 1)
            return false;
        if (state[idx] == 2)
            return true;

        state[idx] = 1;

        for (int next : graph.get(idx)) {
            if (!f(graph, next, state))
                return false;
        }

        state[idx] = 2;
        list.add(idx);
        return true;
    }
}
