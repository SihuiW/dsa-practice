class Solution {

    boolean toP;
    boolean toA;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length, n = heights[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                toP = false;
                toA = false;
                boolean[][] visited = new boolean[m][n];
                f(heights, i, j, visited);
                if(toP && toA) {
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }

    void f(int[][] heights, int i, int j, boolean[][] visited) {
        if(i < 0 || j < 0 || i >= heights.length || j >= heights[0].length) {
            return;
        }
        if(i == 0 || j == 0) {
            toP = true;
        }
        if(i == heights.length - 1 || j == heights[0].length - 1) {
            toA = true;
        }
        if(toP && toA) return;
        if(visited[i][j]) return;

        visited[i][j] = true;

        if(i - 1 >= 0 && heights[i-1][j] <= heights[i][j]) {
            f(heights, i - 1, j, visited);
        }
        if(i + 1 < heights.length && heights[i+1][j] <= heights[i][j]) {
            f(heights, i + 1, j, visited);
        }
        if(j - 1 >= 0 && heights[i][j - 1] <= heights[i][j]) {
            f(heights, i, j - 1, visited);
        }
        if(j + 1 < heights[0].length && heights[i][j + 1] <= heights[i][j]) {
            f(heights, i, j + 1, visited);
        }
        visited[i][j] = false;
    }
}
