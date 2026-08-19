class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> courses = new ArrayList<>();
        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            courses.add(new ArrayList<>());
        }
        for(int[] pair: prerequisites) {
            int course = pair[0];
            int precourse = pair[1];
            courses.get(precourse).add(course);
        }
        for(int i = 0; i < numCourses; i++) {
           if(f(i, courses, visited)) return false;
        }
        return true;
    }

    boolean f(int i, List<List<Integer>> courses, int[] visited) {
        if(visited[i] == 1) return true;
        if(visited[i] == 2) return false;
        visited[i] = 1;
        for(int course: courses.get(i)) {
            if(f(course, courses, visited)) return true;
        }
        visited[i] = 2;
        return false;
    }
}
