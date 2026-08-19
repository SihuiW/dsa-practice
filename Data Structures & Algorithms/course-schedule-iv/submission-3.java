class Solution {
    public List<Boolean> checkIfPrerequisite(
        int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] reach = new boolean[numCourses][numCourses];

        for (int[] p : prerequisites) {
            int pre = p[0];
            int course = p[1];
            reach[pre][course] = true;
        }

        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    if (reach[i][k] && reach[k][j]) {
                        reach[i][j] = true;
                    }
                }
            }
        }

        List<Boolean> res = new ArrayList<>();
        for (int[] q : queries) {
            res.add(reach[q[0]][q[1]]);
        }

        return res;
    }
}