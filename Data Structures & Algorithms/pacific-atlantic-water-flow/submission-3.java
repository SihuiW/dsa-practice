class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new LinkedList<>();
        int m = heights.length, n = heights[0].length;
        boolean[][] toA = new boolean[m][n];
        boolean[][] toP = new boolean[m][n];

        for(int col = 0; col < n; col++) {
            f(heights, 0, col, toP);
        }
        for(int row = 0; row < m; row++) {
            f(heights, row, 0, toP);
        }
        for(int col = 0; col < n; col++) {
            f(heights, m - 1, col, toA);
        }
        for(int row = 0; row < m; row++) {
            f(heights, row, n - 1, toA);
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(toA[i][j] && toP[i][j]) {
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }

    void f(int[][] heights, int i, int j, boolean[][] to) {
        if(to[i][j]) return;
        to[i][j] = true;
        if(i - 1 >= 0 && heights[i-1][j] >= heights[i][j]) {
            f(heights, i - 1, j, to);
        }
        if(i + 1 < heights.length && heights[i+1][j] >= heights[i][j]) {
            f(heights, i + 1, j, to);
        }
        if(j - 1 >= 0 && heights[i][j-1] >= heights[i][j]) {
            f(heights, i, j - 1, to);
        }
        if(j + 1 < heights[0].length && heights[i][j+1] >= heights[i][j]) {
            f(heights, i, j + 1, to);
        }
    }
}
